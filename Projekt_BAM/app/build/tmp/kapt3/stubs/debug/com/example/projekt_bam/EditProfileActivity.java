package com.example.projekt_bam;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u001a\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/projekt_bam/EditProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addressEditText", "Landroid/widget/EditText;", "database", "Lcom/example/projekt_bam/AppDatabase;", "emailEditText", "firstNameEditText", "idNumberEditText", "lastNameEditText", "peselEditText", "phoneNumberEditText", "saveChangesButton", "Landroid/widget/Button;", "decryptUser", "Lcom/example/projekt_bam/UserEntity;", "keystoreInstance", "Lcom/example/projekt_bam/KeystoreWrapper;", "user", "encryptUser", "getLoggedInUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveChanges", "app_debug"})
public final class EditProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.projekt_bam.AppDatabase database;
    private android.widget.EditText emailEditText;
    private android.widget.EditText firstNameEditText;
    private android.widget.EditText lastNameEditText;
    private android.widget.EditText peselEditText;
    private android.widget.EditText addressEditText;
    private android.widget.EditText idNumberEditText;
    private android.widget.EditText phoneNumberEditText;
    private android.widget.Button saveChangesButton;
    
    public EditProfileActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLoggedInUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.projekt_bam.UserEntity> $completion) {
        return null;
    }
    
    private final void saveChanges(com.example.projekt_bam.KeystoreWrapper keystoreInstance, com.example.projekt_bam.UserEntity user) {
    }
    
    private final com.example.projekt_bam.UserEntity decryptUser(com.example.projekt_bam.KeystoreWrapper keystoreInstance, com.example.projekt_bam.UserEntity user) {
        return null;
    }
    
    private final com.example.projekt_bam.UserEntity encryptUser(com.example.projekt_bam.KeystoreWrapper keystoreInstance, com.example.projekt_bam.UserEntity user) {
        return null;
    }
}