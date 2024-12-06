<template>
  <h1>Build diagrams</h1>
  <bpmn-modeler></bpmn-modeler>
</template>

<script>
import BpmnModeler from "@/components/bpmn-modeler/bpmn-modeler.vue";

export default {
  name: "build-diagrams-page",
  components: { BpmnModeler },
  data() {
    return {
      bpmnXML: `<?xml version="1.0" encoding="UTF-8"?>  
                <bpmn:definitions   
                    xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL"   
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
                    id="Definitions_1"   
                    targetNamespace="http://www.omg.org/spec/BPMN/20100524/MODEL">  
                    <bpmn:process id="OrderProcessing" isExecutable="true">  
                        <bpmn:startEvent id="StartEvent_1" name="Order Placed" />  
                        
                        <bpmn:task id="Task_1" name="Verify Order" />  
                        <bpmn:task id="Task_2" name="Process Payment" />  
                        
                        <bpmn:exclusiveGateway id="Gateway_1" name="Payment Successful?" />  
                        
                        <bpmn:endEvent id="EndEvent_1" name="Order Completed" />  
                        <bpmn:endEvent id="EndEvent_2" name="Order Failed" />  
                        
                        <bpmn:sequenceFlow id="Flow_1" sourceRef="StartEvent_1" targetRef="Task_1" />  
                        <bpmn:sequenceFlow id="Flow_2" sourceRef="Task_1" targetRef="Task_2" />  
                        
                        <bpmn:sequenceFlow id="Flow_3" sourceRef="Task_2" targetRef="Gateway_1" />  
                        
                        <bpmn:sequenceFlow id="Flow_4" sourceRef="Gateway_1" targetRef="EndEvent_1">  
                            <bpmn:conditionExpression xsi:type="bpmn:tFormalExpression">#{successfulPayment}</bpmn:conditionExpression>  
                        </bpmn:sequenceFlow>  
                        
                        <bpmn:sequenceFlow id="Flow_5" sourceRef="Gateway_1" targetRef="EndEvent_2">  
                            <bpmn:conditionExpression xsi:type="bpmn:tFormalExpression">#{!successfulPayment}</bpmn:conditionExpression>  
                        </bpmn:sequenceFlow>  
                    </bpmn:process>  
                </bpmn:definitions>`,
    };
  },
};
</script>

<style scoped></style>
