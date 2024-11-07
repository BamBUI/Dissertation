CREATE TABLE additional_part
(
    id          UUID NOT NULL,
    name        VARCHAR(25),
    description VARCHAR(125),
    supplierpn  VARCHAR(125),
    supplier    VARCHAR(125),
    quantity    INTEGER,
    category    VARCHAR(255),
    layer       VARCHAR(255),
    options     VARCHAR(255),
    part_type   VARCHAR(255),
    unit        VARCHAR(255),
    CONSTRAINT pk_additionalpart PRIMARY KEY (id)
);

CREATE TABLE connector
(
    id            UUID    NOT NULL,
    name          VARCHAR(25),
    description   VARCHAR(125),
    supplier_code VARCHAR(125),
    supplier_name VARCHAR(125),
    quantity      INTEGER,
    mandatory     BOOLEAN,
    category      VARCHAR(255),
    layer         VARCHAR(255),
    options       VARCHAR(255),
    part_type     VARCHAR(255),
    unit          VARCHAR(255),
    CONSTRAINT pk_connector PRIMARY KEY (id)
);

CREATE TABLE covering
(
    id            UUID        NOT NULL,
    covering_name VARCHAR(25),
    name          VARCHAR(25),
    description   VARCHAR(125),
    supplierpn    VARCHAR(125),
    supplier      VARCHAR(125),
    quantity      INTEGER,
    category      VARCHAR(255),
    layer         VARCHAR(255),
    options       VARCHAR(255),
    part_type     VARCHAR(255),
    unit          VARCHAR(255),
    CONSTRAINT pk_covering PRIMARY KEY (id)
);

CREATE TABLE cpn
(
    id       UUID NOT NULL,
    name     VARCHAR(25),
    cpn_name VARCHAR(25),
    CONSTRAINT pk_cpn PRIMARY KEY (id)
);

CREATE TABLE dpn
(
    id       UUID NOT NULL,
    name     VARCHAR(25),
    dpn_name VARCHAR(25),
    CONSTRAINT pk_dpn PRIMARY KEY (id)
);

CREATE TABLE information
(
    id                      UUID NOT NULL,
    created_by              VARCHAR(25),
    codename                VARCHAR(25),
    creation_date           TIMESTAMP WITHOUT TIME ZONE,
    author                  VARCHAR(25),
    customer                VARCHAR(25),
    platform                VARCHAR(25),
    model                   VARCHAR(25),
    model_year              VARCHAR(25),
    type                    VARCHAR(25),
    part_number             VARCHAR(25),
    description_1           VARCHAR(25),
    description_2           VARCHAR(25),
    drawing_date            TIMESTAMP WITHOUT TIME ZONE,
    wirelist_import_date    TIMESTAMP WITHOUT TIME ZONE,
    designer_name           VARCHAR(25),
    settings                VARCHAR(25),
    gsd_data                VARCHAR(25),
    customer_data           VARCHAR(25),
    harness_factor          VARCHAR(25),
    wire_length_range       VARCHAR(25),
    general                 VARCHAR(25),
    inhouse_twisted_wire    VARCHAR(25),
    purchased_twisted_wire  VARCHAR(25),
    at_connector            VARCHAR(25),
    at_ringterminal         VARCHAR(25),
    at_dangler              VARCHAR(25),
    at_ultrasonic_splice    VARCHAR(25),
    atucabsplice            VARCHAR(25),
    at_blunt                VARCHAR(25),
    junction_nodes_on_route VARCHAR(25),
    wirebridge_length       VARCHAR(25),
    at_node_with_splice     VARCHAR(25),
    at_node_with_clip       VARCHAR(25),
    at_breakout_node        VARCHAR(25),
    at_other_nodes          VARCHAR(25),
    full_tape               VARCHAR(25),
    solid_tape              VARCHAR(25),
    spiral_tape             VARCHAR(25),
    space_tape              VARCHAR(25),
    tube                    VARCHAR(25),
    sleeve                  VARCHAR(25),
    conduit                 VARCHAR(25),
    region                  VARCHAR(255),
    CONSTRAINT pk_information PRIMARY KEY (id)
);

CREATE TABLE roles
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (name)
);

CREATE TABLE special_wire
(
    id          UUID NOT NULL,
    name        VARCHAR(25),
    description VARCHAR(125),
    supplierpn  VARCHAR(125),
    supplier    VARCHAR(125),
    quantity    INTEGER,
    category    VARCHAR(255),
    layer       VARCHAR(255),
    options     VARCHAR(255),
    part_type   VARCHAR(255),
    unit        VARCHAR(255),
    CONSTRAINT pk_specialwire PRIMARY KEY (id)
);

CREATE TABLE sub_assembly
(
    id          UUID NOT NULL,
    name        VARCHAR(25),
    description VARCHAR(125),
    destination VARCHAR(25),
    cavity      VARCHAR(25),
    supplierpn  VARCHAR(25),
    supplier    VARCHAR(25),
    quantity    INTEGER,
    category    VARCHAR(25),
    layer       VARCHAR(25),
    options     VARCHAR(25),
    part_type   VARCHAR(25),
    unit        VARCHAR(25),
    CONSTRAINT pk_subassembly PRIMARY KEY (id)
);

CREATE TABLE support_part
(
    id                UUID        NOT NULL,
    group_name        VARCHAR(25),
    group_description VARCHAR(125),
    name              VARCHAR(25),
    description       VARCHAR(125),
    supplier_code     VARCHAR(125),
    supplier_name     VARCHAR(125),
    quantity          INTEGER,
    category          VARCHAR(255),
    layer             VARCHAR(255),
    options           VARCHAR(255),
    part_type         VARCHAR(255),
    unit              VARCHAR(255),
    CONSTRAINT pk_supportpart PRIMARY KEY (id)
);

CREATE TABLE tokens
(
    user_id UUID         NOT NULL,
    value   VARCHAR(255) NOT NULL,
    killed  BOOLEAN      NOT NULL,
    CONSTRAINT pk_tokens PRIMARY KEY (user_id)
);

CREATE TABLE users
(
    id        UUID         NOT NULL,
    firstname VARCHAR(25)  NOT NULL,
    lastname  VARCHAR(25)  NOT NULL,
    role      VARCHAR(255),
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    enabled   BOOLEAN      NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE verification_tokens
(
    id          UUID    NOT NULL,
    token       VARCHAR(255),
    user_id     UUID    NOT NULL,
    expiry_date TIMESTAMP WITHOUT TIME ZONE,
    confirmed   BOOLEAN NOT NULL,
    CONSTRAINT pk_verification_tokens PRIMARY KEY (id)
);

CREATE TABLE wire
(
    id          UUID        NOT NULL,
    name        VARCHAR(25) NOT NULL,
    description VARCHAR(125),
    supplierpn  VARCHAR(125),
    supplier    VARCHAR(125),
    quantity    INTEGER,
    category    VARCHAR(255),
    layer       VARCHAR(255),
    options     VARCHAR(255),
    part_type   VARCHAR(255),
    unit        VARCHAR(255),
    CONSTRAINT pk_wire PRIMARY KEY (id)
);

ALTER TABLE tokens
    ADD CONSTRAINT uc_tokens_value UNIQUE (value);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE verification_tokens
    ADD CONSTRAINT uc_verification_tokens_user UNIQUE (user_id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role) REFERENCES roles (name);

ALTER TABLE verification_tokens
    ADD CONSTRAINT FK_VERIFICATION_TOKENS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);