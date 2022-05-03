package com.thoughtworks.todo.mywechat.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeChatUser::class], version = 1, exportSchema = false)
abstract class WeChatUserRoomDatabase : RoomDatabase() {

     abstract fun weChatUserDao(): WeChatUserDao

     companion object{
         private var INSTANCE: WeChatUserRoomDatabase? = null
         fun getDatabase(context: Context): WeChatUserRoomDatabase {
             return INSTANCE ?: synchronized(this) {
                 val instanse = Room.databaseBuilder(
                     context.applicationContext,
                     WeChatUserRoomDatabase::class.java,
                     "weChatUser_database"
                 )
                     .fallbackToDestructiveMigration()
                     .build()
                 INSTANCE = instanse
                 return instanse
             }
         }
     }
}