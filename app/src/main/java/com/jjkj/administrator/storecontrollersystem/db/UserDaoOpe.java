package com.jjkj.administrator.storecontrollersystem.db;

import android.content.Context;

import com.jjkj.administrator.storecontrollersystem.dao.UserDao;
import com.jjkj.administrator.storecontrollersystem.entity.User;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * @author Administrator
 */
public class UserDaoOpe {
    /**
     * 添加数据至数据库
     *
     * @param context context
     * @param stu     User
     */
    public static void insertData(Context context, User stu) {
        DbManager.getDaoSession(context).getUserDao().insert(stu);
    }

    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context context
     * @param list    Users
     */
    public static void insertData(Context context, List<User> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getUserDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context context
     * @param student User
     */
    public static void saveData(Context context, User student) {
        DbManager.getDaoSession(context).getUserDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, User student) {
        DbManager.getDaoSession(context).getUserDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getUserDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getUserDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context context
     * @param student student
     */
    public static void updateData(Context context, User student) {
        DbManager.getDaoSession(context).getUserDao().update(student);
    }

    /**
     * 查询所有数据
     *
     * @param context context
     * @return List<User>
     */
    public static List<User> queryAll(Context context) {
        QueryBuilder<User> builder = DbManager.getDaoSession(context).getUserDao().queryBuilder();
        return builder.build().list();
    }

    /**
     * 分页加载
     *
     * @param context  context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return List<User>
     */
    public static List<User> queryPaging(int pageSize, int pageNum, Context context) {
        UserDao studentDao = DbManager.getDaoSession(context).getUserDao();
        return studentDao.queryBuilder().offset(pageSize * pageNum).limit(pageNum).list();
    }
}
