# login
多用户登录设计与实现
那么怎样才能设计灵活的登录
当用户使用任意方式登录成功后,我们获取的总是User表的一行记录,它实际表示用户的个人资料信息(UserInfo),而用户登录只是为了认证用户(Authenticate),所以无论使用本地账号密码(LoginName)或者第三方账号密码,本质都是为了认证
所以,把用户信息和认证信息分开,数据库表设计
用户信息表(User)
id	主键ID	
username	用户姓名	
phone	手机号	
email	邮箱	

用户登录表(Login)
id	主键ID	
userId	用户ID	
oauthType	登录方式
QQ weibo weixin …	
oauthId	认证号	
oauthToken	登录Token	
oauthExpire	失效时间	
status	状态	
数据库保存信息如下
id	userId	oauthType	oauthId	oauthToken	oauthExpire	status
1	1	NAME	admin	admin		normal
2	1	QQ	123****			normal
3	1	WEIBO	1*******			normal
4	1	WEIXIN	1*******			normal
5	2	NAME	UserAdmin	admin		normal
通过这种表结构设计，使许多原来纠结的问题瞬间解决。
