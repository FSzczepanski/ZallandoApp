package com.example.zalandoapp.entity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.zalandoapp.dao.FavouriteDao;

import org.jetbrains.annotations.NotNull;

@androidx.room.Database(entities={Offer.class},version=1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract FavouriteDao favouriteDao();

    public static synchronized Database getInstance(Context context){
        //wywoła się tylko gdy instancja jest nullem,jeżeli nie jest to zwróci obecną instancje
        if(instance==null){
            instance = Room.databaseBuilder(context, Database.class, "zarandoDB")
                    .addMigrations(
                            MIGRATION_2_3,
                            MIGRATION_3_4,
                            MIGRATION_4_5,
                            MIGRATION_5_6)
                    .build();
        }
        return instance;
    }

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("alter table offer add storeId text");
            database.execSQL("alter table offer add description text");
        }
    };

    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("alter table offer add url text");
        }
    };

    private static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("drop table offer");
            database.execSQL("create table offer (" +
                    "oid text not null primary key," +
                    "title text not null," +
                    "description text," +
                    "price int not null," +
                    "imageUrl text not null)");
        }
    };

    private static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NotNull SupportSQLiteDatabase database) {
//            database.execSQL("");
        }
    };


}
