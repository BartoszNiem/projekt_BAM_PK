package com.example.projekt_bam;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/projekt_bam/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "database", "Lcom/example/projekt_bam/AppDatabase;", "decryptUser", "Lcom/example/projekt_bam/UserEntity;", "keystoreInstance", "Lcom/example/projekt_bam/KeystoreWrapper;", "user", "getLoggedInUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutUser", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDecryptedData", "showEncryptedData", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.projekt_bam.AppDatabase database;
    
    public HomeActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showEncryptedData() {
    }
    
    private final void showDecryptedData(com.example.projekt_bam.KeystoreWrapper keystoreInstance) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLoggedInUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.projekt_bam.UserEntity> $completion) {
        return null;
    }
    
    private final void logoutUser() {
    }
    
    private final com.example.projekt_bam.UserEntity decryptUser(com.example.projekt_bam.KeystoreWrapper keystoreInstance, com.example.projekt_bam.UserEntity user) {
        return null;
    }
}