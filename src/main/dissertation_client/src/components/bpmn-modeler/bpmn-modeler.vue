<template>
  <div id="js-drop-zone" class="drop-zone">
    <div id="js-canvas" style="height: 500px; border: 1px solid #ccc"></div>
    <div id="js-properties-panel"></div>
    <div class="buttons">
      <a id="js-create-diagram" href="#">Create New Diagram</a>
      <a id="js-download-diagram" href="#">Download BPMN</a>
      <a id="js-download-svg" href="#">Download SVG</a>
    </div>
    <div class="error">
      <pre></pre>
    </div>
  </div>
</template>

<script>
import "bpmn-js/dist/assets/diagram-js.css";
import "bpmn-js/dist/assets/bpmn-js.css";
import "bpmn-js/dist/assets/bpmn-font/css/bpmn-embedded.css";
import "@bpmn-io/properties-panel/assets/properties-panel.css";
import "@/components/bpmn-modeler/style.less";

import BpmnModeler from "bpmn-js/lib/Modeler";
import {
  BpmnPropertiesPanelModule,
  BpmnPropertiesProviderModule,
} from "bpmn-js-properties-panel";
import diagramXML from "@/components/bpmn-modeler/newDiagram.bpmn";
import mitt from "mitt";

const emitter = mitt();

export default {
  name: "bpmn-modeler",
  mounted() {
    this.initBpmnModeler();
    this.registerFileDrop();
    emitter.on("commandStack.changed", this.exportArtifacts);
  },
  methods: {
    initBpmnModeler() {
      this.bpmnModeler = new BpmnModeler({
        container: "#js-canvas",
        propertiesPanel: {
          parent: "#js-properties-panel",
        },
        additionalModules: [
          BpmnPropertiesPanelModule,
          BpmnPropertiesProviderModule,
        ],
      });
      this.createNewDiagram();
    },
    async createNewDiagram() {
      await this.openDiagram(diagramXML);
    },
    async openDiagram(xml) {
      try {
        await this.bpmnModeler.importXML(xml);
        this.$el.classList.remove("with-error");
        this.$el.classList.add("with-diagram");
      } catch (err) {
        this.$el.classList.remove("with-diagram");
        this.$el.classList.add("with-error");
        this.$el.querySelector(".error pre").textContent = err.message;
        console.error(err);
      }
    },
    registerFileDrop() {
      const container = this.$el.querySelector("#js-drop-zone");
      if (container) {
        container.addEventListener("dragover", (e) => {
          e.stopPropagation();
          e.preventDefault();
          e.dataTransfer.dropEffect = "copy";
        });

        container.addEventListener("drop", (e) => {
          e.stopPropagation();
          e.preventDefault();
          const files = e.dataTransfer.files;
          const file = files[0];
          const reader = new FileReader();
          reader.onload = (e) => {
            const xml = e.target.result;
            this.openDiagram(xml);
          };
          reader.readAsText(file);
        });
      }
    },
    setEncoded(link, name, data) {
      const encodedData = encodeURIComponent(data);
      if (data) {
        link.classList.add("active");
        link.setAttribute(
          "href",
          "data:application/bpmn20-xml;charset=UTF-8," + encodedData
        );
        link.setAttribute("download", name);
      } else {
        link.classList.remove("active");
      }
    },
    async exportArtifacts() {
      const downloadLink = this.$el.querySelector("#js-download-diagram");
      const downloadSvgLink = this.$el.querySelector("#js-download-svg");

      try {
        const { svg } = await this.bpmnModeler.saveSVG();
        this.setEncoded(downloadSvgLink, "diagram.svg", svg);
      } catch (err) {
        console.error("Error happened saving SVG: ", err);
        this.setEncoded(downloadSvgLink, "diagram.svg", null);
      }

      try {
        const { xml } = await this.bpmnModeler.saveXML({ format: true });
        this.setEncoded(downloadLink, "diagram.bpmn", xml);
      } catch (err) {
        console.log("Error happened saving XML: ", err);
        this.setEncoded(downloadLink, "diagram.bpmn", null);
      }
    },
  },
};
</script>

<style scoped>
#js-canvas {
  height: 500px;
  border: 1px solid #ccc;
}
.drop-zone {
  position: relative;
}
.buttons {
  margin-top: 10px;
}
.error {
  color: red;
}
</style>
