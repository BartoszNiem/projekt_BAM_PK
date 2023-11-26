package com.example.projekt_bam;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/projekt_bam/KeystoreWrapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "KEY_ALIAS", "", "createKey", "", "decryptData", "encryptedData", "Lcom/example/projekt_bam/KeystoreWrapper$EncryptedData;", "encryptData", "data", "getKey", "Ljavax/crypto/SecretKey;", "Companion", "EncryptedData", "app_debug"})
public final class KeystoreWrapper {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String KEY_ALIAS = "your_key_alias";
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.projekt_bam.KeystoreWrapper instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.projekt_bam.KeystoreWrapper.Companion Companion = null;
    
    public KeystoreWrapper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final void createKey() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.projekt_bam.KeystoreWrapper.EncryptedData encryptData(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String decryptData(@org.jetbrains.annotations.NotNull
    com.example.projekt_bam.KeystoreWrapper.EncryptedData encryptedData) {
        return null;
    }
    
    private final javax.crypto.SecretKey getKey() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/projekt_bam/KeystoreWrapper$Companion;", "", "()V", "instance", "Lcom/example/projekt_bam/KeystoreWrapper;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.projekt_bam.KeystoreWrapper getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/example/projekt_bam/KeystoreWrapper$EncryptedData;", "", "data", "", "iv", "", "(Ljava/lang/String;[B)V", "getData", "()Ljava/lang/String;", "getIv", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class EncryptedData {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String data = null;
        @org.jetbrains.annotations.NotNull
        private final byte[] iv = null;
        
        public EncryptedData(@org.jetbrains.annotations.NotNull
        java.lang.String data, @org.jetbrains.annotations.NotNull
        byte[] iv) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] getIv() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.projekt_bam.KeystoreWrapper.EncryptedData copy(@org.jetbrains.annotations.NotNull
        java.lang.String data, @org.jetbrains.annotations.NotNull
        byte[] iv) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}