# KotlinDemo
关于kotlin学习过程中，使用到的一些基础控件，以及kotlin基本用法。


### 你见过最多的MVP
#### 项目架构
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/WX20170720-163440%402x.png" width="300" height="400"/>

#### 整体流程
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/WX20170720-163904%402x.png" width="400" height="300"/>

#### 项目结构
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/1B4DC7F9-C48F-4273-BB91-B5BADAE29E8E.png" width="300" height="400"/>

#### demo核心代码
利用rxkotlin2.0=rxjava2.0 和lambda结合使用，应用场景是，第一步显示数据库中或者其他缓存，然后在显示网络中拉取的数据
``` kotlin
private val onSaveDbStub: (Any) -> Unit = {}
private val onErrorStub: (Throwable) -> Unit = { throw OnErrorNotImplementedException(it) }
private val onFinallyStub: () -> Unit = {}
private val getDataFromDb: () -> Flowable<Any> = { Flowable.concat { } }
private val getDataFromNet: () -> Flowable<Any> = { Flowable.concat { } }


fun <T : Any> getData(db: Flowable<T> = getDataFromDb() as Flowable<T>,
                      net: Flowable<T> = getDataFromNet() as Flowable<T>,
                      onSuccess: (T) -> Unit,
                      onError: (Throwable) -> Unit = onErrorStub,
                      onFinally: () -> Unit = onFinallyStub,
                      onSaveDb: (T) -> Unit = onSaveDbStub): Disposable {
    return Flowable.just(db, net.doAfterNext { onSaveDb(it) })
            .flatMap { it }
            .doAfterTerminate { onFinally }
            .defaultSchedulers()
            .subscribeBy(
                    onNext = {
                        onSuccess(it)
                    },
                    onError = {
                        onError(it)
                    })
}
```
调用demo
``` kotlin
1:
        //1. from the db  2.from the net
        userDao = UserDao()
        userRequest = UserRequest()
        getData(db = userDao.getUsers(),
                net = userRequest.getUsers(),
                onSuccess = {
                    view.onGetUsers(it)
                })

    
2:
 
        getData(net = userRequest.getUsers(),
                onSuccess = {
                    view.onGetUsers(it)
                },
                onSaveDb = {
                    userDao.insertUser(User(it[0].username, it[0].userAge))
                })
```

具体请看demo

### 菜单栏(menus文件夹)
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/0AA025E1C9FFFBD82559DADA462B197C.jpg" width="240" height="400"/>

#### 底部菜单
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/5656BCF168FBB49C88A945104BC19950.jpg" width="240" height="400"/>
<pre>
利用Fragment show和hide 来实现底部tab 的切换
使用到的关键控件：CardView,ViewPager
</pre>

#### 侧边菜单
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/67EE0C00539F3077EB7B6C6356085674.jpg" width="240" height="400"/>
<pre>
利用Fragment show和hide 来实现侧面内容 的切换
使用到的关键控件：DrawerLayout,NavigationView,CoordinatorLayout,AppBarLayout,Toolbar,FloatingActionButton
</pre>

#### 顶部菜单
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/3A361FB7ABD03A26BE33EC482539B465.jpg" width="240" height="400"/>
<pre>
使用到的关键控件：ViewPager,TabLayout
</pre>

#### 下拉菜单
<img src="https://github.com/themores/KotlinDemo/blob/master/menus/D2370FB99A1ED32B0AE2B2C50D39C708.jpg" width="240" height="400"/>
<pre>
使用到的关键控件：menu 菜单
</pre>

