package com.thoughtworks.todo.mywechat.inventory.data

import androidx.room.*
import java.util.concurrent.Flow

/**
*
* 数据访问对象 (DAO) 是一种模式，用于通过提供抽象接口将持久层与应用程序的其余部分分开。
 *  这种隔离遵循 单一职责原则。
 * DAO 的功能是向应用程序的其余部分隐藏在底层持久层中执行数据库操作所涉及的所有复杂性。
 * 这允许独立于使用数据的代码更改数据访问层
 * 创建的 DAO 将是一个自定义接口，为查询/检索、插入、删除和更新数据库提供方便的方法
* */
@Dao
interface WeChatUserDao {
    /*
    * 数据库操作可能需要很长时间才能执行，因此它们应该在单独的线程上运行。
    * 该函数成为挂起函数，以便可以从协程调用该函数
    * */
/*    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weChatUser: WeChatUser)

    @Update
    suspend fun update(weChatUser: WeChatUser)

    @Delete
    suspend fun delete(weChatUser: WeChatUser)*/

/*    @Query("SELECT * from weChatUser WHERE id = :id")
    fun getWeChatUsers(id: Int): Flow<WeChatUser>

    @Query("SELECT * from weChatUser WHERE id = :id")
    fun getWeChatUsers(): Flow<List<WeChatUser>>*/

}