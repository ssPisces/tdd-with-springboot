-----------------
## 示例:停车场管理系统
    作 为: 一个停⻋场小弟 
    我希望:能实现停⻋、取⻋功能 
    以便于:更好的服务⻋主
    
##### 存车
- Given 一个停车场，一辆汽车，When 泊车，Then 得到泊车凭证
- Given 停车场已满，When 泊车，Then '无法停车'

##### 取车
- Given 一个有效的停车Token，When 取车，Then 取到存放的车 
- Given 一个有效的Token，When 取车，Then 可以进行泊车
- Given 一个使用过的Token，When 取车，Then '车辆不存在'
- Given 一个停车场，一个无效的Token，When 取车，Then '车辆不存在'

---------------------
## 练习一：企业注册
    作 为: 企业的法人
    我希望: 能够能够注册成为E章通系统用户
    以便于: 使用印章系统的相关功能
    
    AC-1：法人类型：企业、农专社、个体工商户 （必选）
    AC-2：企业全称：字符 50字（必填）
    AC-3：企业统一社会信用代码：字符 18位（必填）
        3.1 如果社会信用代码已注册，提示："当前企业已注册"
        3.2 如果统一社会信用代码与企业名称不匹配（工商系统验证），提示:“统一社会信用代码与企业名称不匹配”
    AC-4：法人姓名：字符 20位（必填）
    AC-5：证件类型：身份证、护照（必填）
    AC-6：证件号码：身份证 18位，护照 14位（必填）
    AC-7：同步成为中国政务服务平台用户 必须
    AC-8：密码大写、小写、数字组合 （必填）

#### 任务拆分
#### 需要没要求提示的，不做过分开发
#### 类名 名词  方法 动词
- Given 合法的注册信息 When 注册 Then 注册成功
- Given 必填项为空的 When 注册 Then 注册失败
- Given 法人类型不在类型范围内 When 注册 Then 注册失败
- Given 企业全称超长 When 注册 Then 注册失败
- Given 企业信用代码不符长度 When 注册 Then 注册失败
- Given 企业信用代码重复 When 注册 Then 注册失败 提示："当前企业已注册"
- Given 企业信用代码不符合规范 When 注册 Then 注册失败 提示:“统一社会信用代码与企业名称不匹配”
- Given 法人姓名字符超长 When 注册 Then 注册失败
- Given 证件类型超出范围 When 注册 Then 注册失败
- Given 身份证号码位数不符 When 注册 Then 注册失败
- Given 护照号码位数不符 When 注册 Then 注册失败
- Given 注册信息同步失败 When 注册 Then 注册失败
- Given 密码格式不符 When 注册 Then 注册失败
