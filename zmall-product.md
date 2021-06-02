### 商品服务

#### 1.SPU与SKU概念

SPU：苹果6（商品聚合信息的最小单位），如手机->苹果手机->苹果6，苹果6就是SPU。

SKU：土豪金 16G 苹果6 （商品的不可再分的最小单元）。

##### 1.1SPU

SPU(Standard Product Unit)：标准化产品单元。 SPU是商品**信息聚合**的最小单位，是一组**可复用、易检索**的**标准化信息的集合**，该集合描述了一个产品的特性。

**信息聚合：**意味着有识别度的信息被用来作为不同SPU的区分点；不是所有属性，使用的属性值是能够有区分度的关键属性值；

**易检索：**信息聚合与易检索这两个说明，是通过关键属性+属性值的聚合来实现易检索这个目的；目的与使用场景相关联，并非万古不变；哪些属性和属性值会被选为区分SPU的关键属性是会随着场景变化的； 但对于一些场景，已经是共识；比如电商销售，对于标品基本都会选择品牌+型号+关键属性；这也是很多年前我所得到的解释。

**标准化的信息集合：**说明SPU的本质是信息集合，是一个**抽象概念**

##### 1.2SKU

SKU=stock keeping unit(库存量单位) SKU即库存进出计量的单位（买家购买、商家进货、供应商备货、工厂生产都是依据SKU进行的），在服装、鞋类商品中使用最多最普遍。 例如纺织品中一个SKU通常表示：规格尺码、颜色、款式。 SKU是物理上不可分割的最小存货单元。也就是说一款商品，可以根据SKU来确定具体的货物存量。 sku 属性(会影响到库存和价格的属性, 又叫销售属性)---规格

##### 1.3SPU与SKU层级关系

![image-20210527093230408](https://github.com/zrclass/images/blob/master/zmall-images/image-20210527093230408.png)

#### 2.商品服务表设计

##### 2.1属性分组-规格参数-销售属性-三级分类的关联关系

![image-20210527100304618](https://github.com/zrclass/images/blob/master/zmall-images/image-20210527100304618.png)

###### 2.1.1三级分类表

| 字段名称      | 类型    | 长度 | 字段描述                  |
| ------------- | ------- | ---- | ------------------------- |
| cat_id        | bigint  | 20   | 分类id                    |
| name          | varchar | 50   | 分类名称                  |
| parent_cid    | bigint  | 20   | 父分类id                  |
| cat_level     | int     | 11   | 层级                      |
| show_status   | tinyint | 4    | 是否显示[0-不显示，1显示] |
| sort          | int     | 11   | 排序                      |
| icon          | varchar | 255  | 图标地址                  |
| product_unit  | varchar | 50   | 计量单位                  |
| product_count | int     | 11   | 商品数量                  |

###### 2.1.2属性分组表

| 字段名称        | 类型    | 长度 | 字段描述   |
| --------------- | ------- | ---- | ---------- |
| attr_group_id   | bigint  |      | 分组id     |
| attr_group_name | varchar |      | 组名       |
| sort            | int     |      | 排序       |
| description     | varchar |      | 描述       |
| icon            | varchar |      | 组图标     |
| catelog_id      | bigint  |      | 所属分类id |

###### 2.1.3属性表

| 字段名称     | 类型    | 长度 | 字段描述                                                     |
| ------------ | ------- | ---- | ------------------------------------------------------------ |
| attr_id      | bigint  |      | 属性id                                                       |
| attr_name    | varchar |      | 属性名                                                       |
| search_type  | tinyint |      | 是否需要检索[0-不需要，1-需要]                               |
| icon         | varchar |      | 属性图标                                                     |
| value_select | varchar |      | 可选值列表[用逗号分隔]                                       |
| attr_type    | tinyint |      | 属性类型[0-销售属性，1-基本属性                              |
| enable       | bigint  |      | 启用状态[0 - 禁用，1 - 启用]                                 |
| catelog_id   | bigint  |      | 所属分类                                                     |
| show_desc    | tinyint |      | 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整 |

###### 2.1.4属性分组和属性关联表

| 字段名称      | 类型   | 长度 | 字段描述     |
| ------------- | ------ | ---- | ------------ |
| id            | bigint | 20   | id           |
| attr_id       | bigint | 20   | 属性id       |
| attr_group_id | bigint | 20   | 属性分组id   |
| attr_sort     | int    | 11   | 属性组内排序 |

##### 2.2SPU-SKU-属性表的关联关系

![image-20210527100540582](https://github.com/zrclass/images/blob/master/zmall-images/image-20210527100540582.png)

###### 2.2.1SPU表

| 字段名称        | 类型     | 长度 | 字段描述                     |
| --------------- | -------- | ---- | ---------------------------- |
| id              | bigint   | 20   | 商品id                       |
| spu_name        | varchar  | 200  | 商品名称                     |
| spu_description | varchar  | 1000 | 商品描述                     |
| catalog_id      | bigint   | 20   | 所属分类id                   |
| brand_id        | bigint   | 20   | 品牌id                       |
| weight          | decimal  | 18   | 重量                         |
| publish_status  | tinyint  | 4    | 上架状态[0 - 下架，1 - 上架] |
| create_time     | datetime | 0    |                              |
| update_time     | datetime | 0    |                              |

###### 2.2SPU关键属性关联表（商品属性值表）

| 字段名称   | 类型    | 长度 | 字段描述                                |
| ---------- | ------- | ---- | --------------------------------------- |
| id         | bigint  | 20   | id                                      |
| spu_id     | bigint  | 20   | 商品id                                  |
| attr_id    | bigint  | 20   | 属性id                                  |
| attr_name  | varchar | 200  | 属性名                                  |
| attr_value | varchar | 200  | 属性值                                  |
| attr_sort  | int     | 11   | 顺序                                    |
| quick_show | tinyint | 4    | 快速展示【是否展示在介绍上；0-否 1-是】 |

###### 2.2.3SKU表

| 字段名称        | 类型 | 长度 | 字段描述    |
| --------------- | ---- | ---- | ----------- |
| sku_id          |      |      | skuId       |
| spu_id          |      |      | spuId       |
| sku_name        |      |      | sku名称     |
| sku_desc        |      |      | sku介绍描述 |
| catalog_id      |      |      | 所属分类id  |
| brand_id        |      |      | 品牌id      |
| sku_default_img |      |      | 默认图片    |
| sku_title       |      |      | 标题        |
| sku_subtitle    |      |      | 副标题      |
| price           |      |      | 价格        |
| sale_count      |      |      | 销量        |

###### 2.2.4SKU销售属性关联表（销售属性值表）

| 字段名称   | 类型 | 长度 | 字段描述   |
| ---------- | ---- | ---- | ---------- |
| id         |      |      | id         |
| sku_id     |      |      | sku_id     |
| attr_id    |      |      | attr_id    |
| attr_name  |      |      | 销售属性名 |
| attr_value |      |      | 销售属性值 |
| attr_sort  |      |      | 顺序       |

##### 3.商品服务后台操作介绍

###### 3.1分类维护

3.1.1获取商品分类树

![image-20210528082510348](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528082510348.png)

3.1.2 点击添加，添加分类

![image-20210528082836834](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528082836834.png)

###### 3.2品牌管理

3.2.1获取品牌列表

![image-20210528083101068](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528083101068.png)

3.2.2新增品牌

![image-20210528083433959](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528083433959.png)

3.2.3品牌关联分类

![image-20210528083626008](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528083626008.png)

![image-20210528083725387](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528083725387.png)

![image-20210528083813169](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528083813169.png)

###### 3.3属性规格参数维护

3.3.1获取规格参数列表

![image-20210528090140416](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528090140416.png)

3.3.2新增SPU商品属性规格参数

![image-20210528090627343](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528090627343.png)

3.3.3新增SKU销售属性规格参数

![image-20210528090853593](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528090853593.png)

###### 3.4SPU属性分组维护(属性分组关联属性)

3.4.1获取SPU属性分组列表

![image-20210528084118406](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528084118406.png)

3.4.2新增属性分组

![image-20210528085010418](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528085010418.png)

3.4.3SPU属性分组关联SPU属性

![image-20210528084241052](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528084241052.png)

###### 3.5SKU销售属性规格参数管理

与属性规格维护相同,只是在属性类型上智能选择销售属性。本质上属于属性规格参数

3.5.1获取销售属性规格参数列表

![image-20210528091441123](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528091441123.png)

3.5.2添加销售属性规格参数

![image-20210528091825492](https://github.com/zrclass/images/blob/master/zmall-images/image-20210528091825492.png)

