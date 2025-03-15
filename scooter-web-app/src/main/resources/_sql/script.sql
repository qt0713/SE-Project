create table AUTH_THIRD_USER
(
    ID          varchar(20)  not null
        primary key,
    THIRD_ID    varchar(255) null comment '三方用户id',
    USER_ID     varchar(20)  null comment '系统用户id',
    AVATAR      longtext     null comment '头像',
    NAME        varchar(255) null comment '姓名',
    NICKNAME    varchar(255) null comment '昵称',
    GENDER      varchar(255) null comment '性别',
    CATEGORY    varchar(255) null comment '分类',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '三方用户' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table BIZ_NOTICE
(
    ID          varchar(20)  not null comment '主键'
        primary key,
    TITLE       varchar(200) null comment '标题',
    IMAGE       varchar(200) null comment '封面图',
    CONTENT     text         null comment '内容',
    DIGEST      varchar(300) null comment '摘要',
    TYPE        varchar(50)  null comment '类型',
    PLACE       varchar(50)  null comment '发布位置',
    STATUS      varchar(10)  null comment '状态',
    SORT_CODE   int          null comment '排序',
    REMARK      varchar(500) null comment '备注',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '更新时间',
    UPDATE_USER varchar(20)  null comment '更新用户'
)
    comment '通知公告' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table CLIENT_RELATION
(
    ID        varchar(20)  not null
        primary key,
    OBJECT_ID varchar(255) null comment '对象ID',
    TARGET_ID varchar(255) null comment '目标ID',
    CATEGORY  varchar(255) null comment '分类',
    EXT_JSON  longtext     null comment '扩展信息'
)
    comment '关系' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table CLIENT_USER
(
    ID                   varchar(20)  not null
        primary key,
    AVATAR               longtext     null comment '头像',
    SIGNATURE            longtext     null comment '签名',
    ACCOUNT              varchar(255) null comment '账号',
    PASSWORD             varchar(255) null comment '密码',
    NAME                 varchar(255) null comment '姓名',
    NICKNAME             varchar(255) null comment '昵称',
    GENDER               varchar(255) null comment '性别',
    AGE                  varchar(255) null comment '年龄',
    BIRTHDAY             varchar(255) null comment '出生日期',
    NATION               varchar(255) null comment '民族',
    NATIVE_PLACE         varchar(255) null comment '籍贯',
    HOME_ADDRESS         text         null comment '家庭住址',
    MAILING_ADDRESS      text         null comment '通信地址',
    ID_CARD_TYPE         varchar(255) null comment '证件类型',
    ID_CARD_NUMBER       varchar(255) null comment '证件号码',
    CULTURE_LEVEL        varchar(255) null comment '文化程度',
    POLITICAL_OUTLOOK    varchar(255) null comment '政治面貌',
    COLLEGE              varchar(255) null comment '毕业院校',
    EDUCATION            varchar(255) null comment '学历',
    EDU_LENGTH           varchar(255) null comment '学制',
    DEGREE               varchar(255) null comment '学位',
    PHONE                varchar(255) null comment '手机',
    EMAIL                varchar(255) null comment '邮箱',
    HOME_TEL             varchar(255) null comment '家庭电话',
    OFFICE_TEL           varchar(255) null comment '办公电话',
    EMERGENCY_CONTACT    varchar(255) null comment '紧急联系人',
    EMERGENCY_PHONE      varchar(255) null comment '紧急联系人电话',
    EMERGENCY_ADDRESS    text         null comment '紧急联系人地址',
    LAST_LOGIN_IP        varchar(255) null comment '上次登录ip',
    LAST_LOGIN_ADDRESS   varchar(255) null comment '上次登录地点',
    LAST_LOGIN_TIME      datetime     null comment '上次登录时间',
    LAST_LOGIN_DEVICE    text         null comment '上次登录设备',
    LATEST_LOGIN_IP      varchar(255) null comment '最新登录ip',
    LATEST_LOGIN_ADDRESS varchar(255) null comment '最新登录地点',
    LATEST_LOGIN_TIME    datetime     null comment '最新登录时间',
    LATEST_LOGIN_DEVICE  text         null comment '最新登录设备',
    USER_STATUS          varchar(255) null comment '用户状态',
    SORT_CODE            int          null comment '排序码',
    EXT_JSON             longtext     null comment '扩展信息',
    DELETE_FLAG          varchar(255) null comment '删除标志',
    CREATE_TIME          datetime     null comment '创建时间',
    CREATE_USER          varchar(20)  null comment '创建用户',
    UPDATE_TIME          datetime     null comment '修改时间',
    UPDATE_USER          varchar(20)  null comment '修改用户'
)
    comment 'C端用户' collate = utf8mb4_general_ci
                      row_format = DYNAMIC;

create table CreditCard
(
    id          varchar(20)                          not null
        primary key,
    user_id     varchar(20)                          not null,
    card_number varchar(255)                         not null,
    card_holder varchar(100)                         not null,
    expiry_date varchar(10)                          not null,
    cvv         varchar(255)                         null,
    is_default  tinyint(1) default 0                 null,
    create_time datetime   default CURRENT_TIMESTAMP null,
    update_time datetime   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint creditcard_ibfk_1
        foreign key (user_id) references CLIENT_USER (ID)
)
    collate = utf8mb4_general_ci;

create index user_id
    on CreditCard (user_id);

create table DEV_CONFIG
(
    ID           varchar(20)  not null
        primary key,
    CONFIG_KEY   varchar(255) null comment '配置键',
    CONFIG_VALUE longtext     null comment '配置值',
    CATEGORY     varchar(255) null comment '分类',
    REMARK       varchar(255) null comment '备注',
    SORT_CODE    int          null comment '排序码',
    EXT_JSON     longtext     null comment '扩展信息',
    DELETE_FLAG  varchar(255) null comment '删除标志',
    CREATE_TIME  datetime     null comment '创建时间',
    CREATE_USER  varchar(20)  null comment '创建用户',
    UPDATE_TIME  datetime     null comment '修改时间',
    UPDATE_USER  varchar(20)  null comment '修改用户'
)
    comment '配置' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_DICT
(
    ID          varchar(20)  not null
        primary key,
    PARENT_ID   varchar(20)  null comment '父id',
    DICT_LABEL  varchar(255) null comment '字典文字',
    DICT_VALUE  varchar(255) null comment '字典值',
    CATEGORY    varchar(255) null comment '分类',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '字典' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_EMAIL
(
    ID               varchar(20)  not null
        primary key,
    ENGINE           varchar(255) null comment '邮件引擎',
    SEND_ACCOUNT     varchar(255) null comment '发件人邮箱',
    SEND_USER        varchar(255) null comment '发件人昵称',
    RECEIVE_ACCOUNTS text         null comment '接收人',
    SUBJECT          text         null comment '邮件主题',
    CONTENT          longtext     null comment '邮件正文',
    TAG_NAME         varchar(255) null comment '标签名',
    TEMPLATE_NAME    text         null comment '模板名',
    TEMPLATE_PARAM   text         null comment '发送参数',
    RECEIPT_INFO     longtext     null comment '回执信息',
    EXT_JSON         longtext     null comment '扩展信息',
    DELETE_FLAG      varchar(255) null comment '删除标志',
    CREATE_TIME      datetime     null comment '创建时间',
    CREATE_USER      varchar(20)  null comment '创建用户',
    UPDATE_TIME      datetime     null comment '修改时间',
    UPDATE_USER      varchar(20)  null comment '修改用户'
)
    comment '邮件' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_FILE
(
    ID            varchar(20)  not null
        primary key,
    ENGINE        varchar(255) null comment '存储引擎',
    BUCKET        varchar(255) null comment '存储桶',
    NAME          text         null comment '文件名称',
    SUFFIX        varchar(255) null comment '文件后缀',
    SIZE_KB       bigint       null comment '文件大小kb',
    SIZE_INFO     varchar(255) null comment '文件大小（格式化后）',
    OBJ_NAME      text         null comment '文件的对象名（唯一名称）',
    STORAGE_PATH  text         null comment '文件存储路径',
    DOWNLOAD_PATH text         null comment '文件下载路径',
    THUMBNAIL     longtext     null comment '图片缩略图',
    EXT_JSON      longtext     null comment '扩展信息',
    DELETE_FLAG   varchar(255) null comment '删除标志',
    CREATE_TIME   datetime     null comment '创建时间',
    CREATE_USER   varchar(20)  null comment '创建用户',
    UPDATE_TIME   datetime     null comment '修改时间',
    UPDATE_USER   varchar(20)  null comment '修改用户'
)
    comment '文件' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_JOB
(
    ID              varchar(20)  not null
        primary key,
    NAME            varchar(255) null comment '名称',
    CODE            varchar(255) null comment '编码',
    CATEGORY        varchar(255) null comment '分类',
    ACTION_CLASS    varchar(255) null comment '任务类名',
    CRON_EXPRESSION varchar(255) null comment 'cron表达式',
    JOB_STATUS      varchar(255) null comment '任务状态',
    SORT_CODE       int          null comment '排序码',
    EXT_JSON        longtext     null comment '扩展信息',
    DELETE_FLAG     varchar(255) null comment '删除标志',
    CREATE_TIME     datetime     null comment '创建时间',
    CREATE_USER     varchar(20)  null comment '创建用户',
    UPDATE_TIME     datetime     null comment '修改时间',
    UPDATE_USER     varchar(20)  null comment '修改用户'
)
    comment '定时任务' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table DEV_LOG
(
    ID          varchar(20)  not null comment '主键'
        primary key,
    CATEGORY    varchar(255) null comment '日志分类',
    NAME        varchar(255) null comment '日志名称',
    EXE_STATUS  varchar(255) null comment '执行状态',
    EXE_MESSAGE longtext     null comment '具体消息',
    OP_IP       varchar(255) null comment '操作ip',
    OP_ADDRESS  varchar(255) null comment '操作地址',
    OP_BROWSER  varchar(255) null comment '操作浏览器',
    OP_OS       varchar(255) null comment '操作系统',
    CLASS_NAME  varchar(255) null comment '类名称',
    METHOD_NAME varchar(255) null comment '方法名称',
    REQ_METHOD  varchar(255) null comment '请求方式',
    REQ_URL     longtext     null comment '请求地址',
    PARAM_JSON  longtext     null comment '请求参数',
    RESULT_JSON longtext     null comment '返回结果',
    OP_TIME     datetime     null comment '操作时间',
    OP_USER     varchar(255) null comment '操作人姓名',
    SIGN_DATA   longtext     null comment '签名数据',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '日志' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_MESSAGE
(
    ID          varchar(20)  not null
        primary key,
    CATEGORY    varchar(255) null comment '分类',
    SUBJECT     text         null comment '主题',
    CONTENT     longtext     null comment '正文',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '站内信' collate = utf8mb4_general_ci
                     row_format = DYNAMIC;

create table DEV_RELATION
(
    ID        varchar(20)  not null
        primary key,
    OBJECT_ID varchar(255) null comment '对象ID',
    TARGET_ID varchar(255) null comment '目标ID',
    CATEGORY  varchar(255) null comment '分类',
    EXT_JSON  longtext     null comment '扩展信息'
)
    comment '关系' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table DEV_SLIDESHOW
(
    ID           varchar(20)  not null comment '主键'
        primary key,
    TITLE        varchar(200) null comment '标题',
    PLACE        varchar(500) null comment '展示位置',
    IMAGE        varchar(200) null comment '图片',
    PATH_DETAILS varchar(500) null comment '路径详情',
    STATUS       varchar(10)  null comment '状态',
    SORT_CODE    int          null comment '排序',
    EXT_JSON     longtext     null comment '扩展信息',
    DELETE_FLAG  varchar(255) null comment '删除标志',
    CREATE_TIME  datetime     null comment '创建时间',
    CREATE_USER  varchar(20)  null comment '创建用户',
    UPDATE_TIME  datetime     null comment '更新时间',
    UPDATE_USER  varchar(20)  null comment '更新用户'
)
    comment '轮播图' collate = utf8mb4_general_ci
                     row_format = DYNAMIC;

create table DEV_SMS
(
    ID             varchar(20)  not null
        primary key,
    ENGINE         varchar(255) null comment '短信引擎',
    PHONE_NUMBERS  text         null comment '手机号',
    SIGN_NAME      text         null comment '短信签名',
    TEMPLATE_CODE  text         null comment '模板编码',
    TEMPLATE_PARAM text         null comment '发送参数',
    RECEIPT_INFO   longtext     null comment '回执信息',
    EXT_JSON       longtext     null comment '扩展信息',
    DELETE_FLAG    varchar(255) null comment '删除标志',
    CREATE_TIME    datetime     null comment '创建时间',
    CREATE_USER    varchar(20)  null comment '创建用户',
    UPDATE_TIME    datetime     null comment '修改时间',
    UPDATE_USER    varchar(20)  null comment '修改用户'
)
    comment '短信' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table GEN_BASIC
(
    ID            varchar(20)  not null comment '主键'
        primary key,
    DB_TABLE      varchar(255) null comment '主表',
    DB_TABLE_KEY  varchar(255) null comment '主表主键',
    PLUGIN_NAME   varchar(255) null comment '插件名',
    MODULE_NAME   varchar(255) null comment '模块名',
    TABLE_PREFIX  varchar(255) null comment '移除表前缀',
    GENERATE_TYPE varchar(255) null comment '生成方式',
    MODULE        varchar(255) null comment '所属模块',
    MENU_PID      varchar(255) null comment '上级目录',
    MOBILE_MODULE varchar(255) null comment '移动端所属模块',
    FUNCTION_NAME varchar(255) null comment '功能名',
    BUS_NAME      varchar(255) null comment '业务名',
    CLASS_NAME    varchar(255) null comment '类名',
    FORM_LAYOUT   varchar(255) null comment '表单布局',
    GRID_WHETHER  varchar(255) null comment '使用栅格',
    PACKAGE_NAME  varchar(255) null comment '包名',
    AUTHOR_NAME   varchar(255) null comment '作者',
    SORT_CODE     int          null comment '排序',
    DELETE_FLAG   varchar(255) null comment '删除标志',
    CREATE_TIME   datetime     null comment '创建时间',
    CREATE_USER   varchar(20)  null comment '创建用户',
    UPDATE_TIME   datetime     null comment '修改时间',
    UPDATE_USER   varchar(20)  null comment '修改用户'
)
    comment '生成基础' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table GEN_CONFIG
(
    ID                 varchar(20)  not null comment '主键'
        primary key,
    BASIC_ID           varchar(20)  null comment '基础ID',
    IS_TABLE_KEY       varchar(255) null comment '是否主键',
    FIELD_NAME         varchar(255) null comment '字段',
    FIELD_REMARK       varchar(255) null comment '名称',
    FIELD_TYPE         varchar(255) null comment '类型',
    FIELD_JAVA_TYPE    varchar(255) null comment '实体类型',
    EFFECT_TYPE        varchar(255) null comment '作用类型',
    DICT_TYPE_CODE     varchar(255) null comment '字典',
    WHETHER_TABLE      varchar(255) null comment '列表显示',
    WHETHER_RETRACT    varchar(255) null comment '列省略',
    WHETHER_ADD_UPDATE varchar(255) null comment '是否增改',
    WHETHER_REQUIRED   varchar(255) null comment '必填',
    QUERY_WHETHER      varchar(255) null comment '查询',
    QUERY_TYPE         varchar(255) null comment '查询方式',
    SORT_CODE          int          null comment '排序',
    DELETE_FLAG        varchar(20)  null comment '删除标志',
    CREATE_TIME        datetime     null comment '创建时间',
    CREATE_USER        varchar(20)  null comment '创建用户',
    UPDATE_TIME        datetime     null comment '修改时间',
    UPDATE_USER        varchar(20)  null comment '修改用户'
)
    comment '生成配置' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table MOBILE_RESOURCE
(
    ID          varchar(20)  not null comment '主键'
        primary key,
    PARENT_ID   varchar(255) null comment '父ID',
    TITLE       varchar(255) null comment '名称',
    CODE        varchar(255) null comment '编码',
    CATEGORY    varchar(255) null comment '分类',
    MODULE      varchar(255) null comment '模块',
    MENU_TYPE   varchar(255) null comment '菜单类型',
    PATH        varchar(255) null comment '路径',
    ICON        varchar(255) null comment '图标',
    COLOR       varchar(255) null comment '颜色',
    REG_TYPE    varchar(255) null comment '规则类型',
    STATUS      varchar(255) null comment '可用状态',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '移动资源' collate = utf8mb4_general_ci
                       row_format = DYNAMIC;

create table RentalOption
(
    id             varchar(20)                        not null
        primary key,
    option_name    varchar(50)                        not null,
    duration_hours int                                not null,
    base_price     decimal(10, 2)                     not null,
    description    text                               null,
    create_time    datetime default CURRENT_TIMESTAMP null,
    update_time    datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    collate = utf8mb4_general_ci;

create table SYS_GROUP
(
    ID          varchar(50)  not null comment '主键'
        primary key,
    NAME        varchar(200) not null comment '名称',
    REMARK      varchar(500) null comment '备注',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '用户组' collate = utf8mb4_general_ci
                     row_format = DYNAMIC;

create table SYS_ORG
(
    ID          varchar(20)  not null
        primary key,
    PARENT_ID   varchar(20)  null comment '父id',
    DIRECTOR_ID varchar(20)  null comment '主管ID',
    NAME        varchar(255) null comment '名称',
    CODE        varchar(255) null comment '编码',
    CATEGORY    varchar(255) null comment '分类',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '组织' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table SYS_POSITION
(
    ID          varchar(20)  not null
        primary key,
    ORG_ID      varchar(20)  null comment '组织id',
    NAME        varchar(255) null comment '名称',
    CODE        varchar(255) null comment '编码',
    CATEGORY    varchar(255) null comment '分类',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '职位' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table SYS_RELATION
(
    ID        varchar(20)  not null
        primary key,
    OBJECT_ID varchar(255) null comment '对象ID',
    TARGET_ID varchar(255) null comment '目标ID',
    CATEGORY  varchar(255) null comment '分类',
    EXT_JSON  longtext     null comment '扩展信息'
)
    comment '关系' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table SYS_RESOURCE
(
    ID          varchar(20)  not null
        primary key,
    PARENT_ID   varchar(255) null comment '父id',
    TITLE       varchar(255) null comment '标题',
    NAME        varchar(255) null comment '别名',
    CODE        varchar(255) null comment '编码',
    CATEGORY    varchar(255) null comment '分类',
    MODULE      varchar(255) null comment '模块',
    MENU_TYPE   varchar(255) null comment '菜单类型',
    PATH        text         null comment '路径',
    COMPONENT   varchar(255) null comment '组件',
    ICON        varchar(255) null comment '图标',
    COLOR       varchar(255) null comment '颜色',
    VISIBLE     varchar(255) null comment '是否可见',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '资源' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table SYS_ROLE
(
    ID          varchar(20)  not null
        primary key,
    ORG_ID      varchar(20)  null comment '组织id',
    NAME        varchar(255) null comment '名称',
    CODE        varchar(255) null comment '编码',
    CATEGORY    varchar(255) null comment '分类',
    SORT_CODE   int          null comment '排序码',
    EXT_JSON    longtext     null comment '扩展信息',
    DELETE_FLAG varchar(255) null comment '删除标志',
    CREATE_TIME datetime     null comment '创建时间',
    CREATE_USER varchar(20)  null comment '创建用户',
    UPDATE_TIME datetime     null comment '修改时间',
    UPDATE_USER varchar(20)  null comment '修改用户'
)
    comment '角色' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table SYS_USER
(
    ID                   varchar(20)  not null
        primary key,
    AVATAR               longtext     null comment '头像',
    SIGNATURE            longtext     null comment '签名',
    ACCOUNT              varchar(255) null comment '账号',
    PASSWORD             varchar(255) null comment '密码',
    NAME                 varchar(255) null comment '姓名',
    NICKNAME             varchar(255) null comment '昵称',
    GENDER               varchar(255) null comment '性别',
    AGE                  varchar(255) null comment '年龄',
    BIRTHDAY             varchar(255) null comment '出生日期',
    NATION               varchar(255) null comment '民族',
    NATIVE_PLACE         varchar(255) null comment '籍贯',
    HOME_ADDRESS         text         null comment '家庭住址',
    MAILING_ADDRESS      text         null comment '通信地址',
    ID_CARD_TYPE         varchar(255) null comment '证件类型',
    ID_CARD_NUMBER       varchar(255) null comment '证件号码',
    CULTURE_LEVEL        varchar(255) null comment '文化程度',
    POLITICAL_OUTLOOK    varchar(255) null comment '政治面貌',
    COLLEGE              varchar(255) null comment '毕业院校',
    EDUCATION            varchar(255) null comment '学历',
    EDU_LENGTH           varchar(255) null comment '学制',
    DEGREE               varchar(255) null comment '学位',
    PHONE                varchar(255) null comment '手机',
    EMAIL                varchar(255) null comment '邮箱',
    HOME_TEL             varchar(255) null comment '家庭电话',
    OFFICE_TEL           varchar(255) null comment '办公电话',
    EMERGENCY_CONTACT    varchar(255) null comment '紧急联系人',
    EMERGENCY_PHONE      varchar(255) null comment '紧急联系人电话',
    EMERGENCY_ADDRESS    text         null comment '紧急联系人地址',
    EMP_NO               varchar(255) null comment '员工编号',
    ENTRY_DATE           varchar(255) null comment '入职日期',
    ORG_ID               varchar(20)  null comment '机构id',
    POSITION_ID          varchar(20)  null comment '职位id',
    POSITION_LEVEL       varchar(255) null comment '职级',
    DIRECTOR_ID          varchar(20)  null comment '主管id',
    POSITION_JSON        longtext     null comment '兼任信息',
    LAST_LOGIN_IP        varchar(255) null comment '上次登录ip',
    LAST_LOGIN_ADDRESS   varchar(255) null comment '上次登录地点',
    LAST_LOGIN_TIME      datetime     null comment '上次登录时间',
    LAST_LOGIN_DEVICE    text         null comment '上次登录设备',
    LATEST_LOGIN_IP      varchar(255) null comment '最新登录ip',
    LATEST_LOGIN_ADDRESS varchar(255) null comment '最新登录地点',
    LATEST_LOGIN_TIME    datetime     null comment '最新登录时间',
    LATEST_LOGIN_DEVICE  text         null comment '最新登录设备',
    USER_STATUS          varchar(255) null comment '用户状态',
    SORT_CODE            int          null comment '排序码',
    EXT_JSON             longtext     null comment '扩展信息',
    DELETE_FLAG          varchar(255) null comment '删除标志',
    CREATE_TIME          datetime     null comment '创建时间',
    CREATE_USER          varchar(20)  null comment '创建用户',
    UPDATE_TIME          datetime     null comment '修改时间',
    UPDATE_USER          varchar(20)  null comment '修改用户'
)
    comment '用户' collate = utf8mb4_general_ci
                   row_format = DYNAMIC;

create table Scooter
(
    id                    varchar(20)                                                                not null
        primary key,
    model                 varchar(50)                                                                not null,
    status                enum ('AVAILABLE', 'UNAVAILABLE', 'MAINTENANCE') default 'AVAILABLE'       not null,
    location              varchar(20)                                                                null,
    battery_level         int                                              default 100               not null,
    last_maintenance_date datetime                                                                   null,
    create_time           datetime                                         default CURRENT_TIMESTAMP null,
    update_time           datetime                                         default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    collate = utf8mb4_general_ci;

create table Booking
(
    id                varchar(20)                                                                                not null
        primary key,
    user_id           varchar(20)                                                                                null,
    scooter_id        varchar(20)                                                                                not null,
    option_id         varchar(20)                                                                                not null,
    start_time        datetime                                                                                   not null,
    end_time          datetime                                                                                   not null,
    status            enum ('PENDING', 'ACTIVE', 'COMPLETED', 'CANCELLED', 'EXTENDED') default 'PENDING'         not null,
    total_price       decimal(10, 2)                                                                             not null,
    booking_reference varchar(50)                                                                                not null,
    create_time       datetime                                                         default CURRENT_TIMESTAMP null,
    update_time       datetime                                                         default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint booking_reference
        unique (booking_reference),
    constraint booking_ibfk_1
        foreign key (user_id) references CLIENT_USER (ID),
    constraint booking_ibfk_2
        foreign key (scooter_id) references Scooter (id),
    constraint booking_ibfk_3
        foreign key (option_id) references RentalOption (id)
)
    collate = utf8mb4_general_ci;

create index option_id
    on Booking (option_id);

create index scooter_id
    on Booking (scooter_id);

create index user_id
    on Booking (user_id);

create table Feedback
(
    id            varchar(20)                                                        not null
        primary key,
    user_id       varchar(20)                                                        null,
    scooter_id    varchar(20)                                                        null,
    booking_id    varchar(20)                                                        null,
    feedback_text text                                                               not null,
    priority      enum ('LOW', 'MEDIUM', 'HIGH')           default 'LOW'             not null,
    status        enum ('OPEN', 'IN_PROGRESS', 'RESOLVED') default 'OPEN'            not null,
    create_time   datetime                                 default CURRENT_TIMESTAMP null,
    update_time   datetime                                 default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint feedback_ibfk_1
        foreign key (user_id) references CLIENT_USER (ID),
    constraint feedback_ibfk_2
        foreign key (scooter_id) references Scooter (id),
    constraint feedback_ibfk_3
        foreign key (booking_id) references Booking (id)
)
    collate = utf8mb4_general_ci;

create index booking_id
    on Feedback (booking_id);

create index scooter_id
    on Feedback (scooter_id);

create index user_id
    on Feedback (user_id);

create table Payment
(
    id                    varchar(20)                                         not null
        primary key,
    booking_id            varchar(20)                                         not null,
    amount                decimal(10, 2)                                      not null,
    payment_method        enum ('CREDIT_CARD', 'CASH', 'OTHER')               not null,
    card_id               varchar(20)                                         null,
    transaction_reference varchar(100)                                        not null,
    status                enum ('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') not null,
    create_time           datetime default CURRENT_TIMESTAMP                  null,
    constraint payment_ibfk_1
        foreign key (booking_id) references Booking (id),
    constraint payment_ibfk_2
        foreign key (card_id) references CreditCard (id)
)
    collate = utf8mb4_general_ci;

create index booking_id
    on Payment (booking_id);

create index card_id
    on Payment (card_id);

create table UserDiscount
(
    id                  varchar(20)                                 not null
        primary key,
    user_id             varchar(20)                                 not null,
    discount_type       enum ('FREQUENT_USER', 'STUDENT', 'SENIOR') not null,
    discount_percentage decimal(5, 2)                               not null,
    valid_from          date                                        not null,
    valid_until         date                                        null,
    proof_document      varchar(255)                                null,
    create_time         datetime default CURRENT_TIMESTAMP          null,
    update_time         datetime default CURRENT_TIMESTAMP          null on update CURRENT_TIMESTAMP,
    constraint userdiscount_ibfk_1
        foreign key (user_id) references CLIENT_USER (ID)
)
    collate = utf8mb4_general_ci;

create index user_id
    on UserDiscount (user_id);


