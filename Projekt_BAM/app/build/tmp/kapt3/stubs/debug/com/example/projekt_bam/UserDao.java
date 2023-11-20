package com.example.projekt_bam;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\'J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\'J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\'\u00a8\u0006\u0011"}, d2 = {"Lcom/example/projekt_bam/UserDao;", "", "getAllUsers", "", "Lcom/example/projekt_bam/UserEntity;", "getUserByEmail", "email", "", "getUserByEmailAndPassword", "password", "getUserById", "userId", "", "insertUser", "", "user", "updateUser", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert
    public abstract void insertUser(@org.jetbrains.annotations.NotNull
    com.example.projekt_bam.UserEntity user);
    
    @androidx.room.Update
    public abstract void updateUser(@org.jetbrains.annotations.NotNull
    com.example.projekt_bam.UserEntity user);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :email")
    @org.jetbrains.annotations.Nullable
    public abstract com.example.projekt_bam.UserEntity getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email);
    
    @androidx.room.Query(value = "SELECT * FROM users")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.projekt_bam.UserEntity> getAllUsers();
    
    @androidx.room.Query(value = "SELECT * FROM users where email = :email and password = :password")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.projekt_bam.UserEntity getUserByEmailAndPassword(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE id = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract com.example.projekt_bam.UserEntity getUserById(long userId);
}