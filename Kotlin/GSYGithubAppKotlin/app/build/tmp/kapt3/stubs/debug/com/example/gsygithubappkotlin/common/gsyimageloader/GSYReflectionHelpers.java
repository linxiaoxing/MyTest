package com.example.gsygithubappkotlin.common.gsyimageloader;

import java.lang.System;

/**
 * Collection of helper methods for calling methods and accessing fields reflectively.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u001b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003?@AB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J=\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u000b2\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000e\u00a2\u0006\u0002\u0010\u000fJI\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000e\u00a2\u0006\u0002\u0010\u0014J=\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000e\u00a2\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000e\u00a2\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000b\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u0005J#\u0010\u001d\u001a\u0002H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000b\u00a2\u0006\u0002\u0010!J!\u0010\"\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0005\u00a2\u0006\u0002\u0010%J%\u0010&\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010$\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\'J\u0019\u0010&\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010(\u001a\u00020)\u00a2\u0006\u0002\u0010*J\u001a\u0010+\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005J\u0010\u0010/\u001a\u0002002\u0006\u0010(\u001a\u00020)H\u0002J\u001f\u00101\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000b\u00a2\u0006\u0002\u0010\u001aJ*\u00102\u001a\u0002002\n\u00103\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0001J\u001e\u00102\u001a\u0002002\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0001J\"\u00105\u001a\u0002002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010$\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0001J\u0016\u00105\u001a\u0002002\u0006\u0010(\u001a\u00020)2\u0006\u00104\u001a\u00020\u0001JK\u00106\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\f\b\u0001\u00107*\u000608j\u0002`92\n\u0010:\u001a\u0006\u0012\u0002\b\u00030\u000b2\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u0002H70\u000b2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H\t0=H\u0002\u00a2\u0006\u0002\u0010>RL\u0010\u0003\u001a@\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers;", "", "()V", "PRIMITIVE_RETURN_VALUES", "", "", "kotlin.jvm.PlatformType", "", "callConstructor", "R", "clazz", "Ljava/lang/Class;", "classParameters", "", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;", "(Ljava/lang/Class;[Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)Ljava/lang/Object;", "callInstanceMethod", "cl", "instance", "methodName", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/String;[Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)Ljava/lang/Object;", "callStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)Ljava/lang/Object;", "createNullProxy", "T", "(Ljava/lang/Class;)Ljava/lang/Object;", "defaultValueForType", "returnType", "defaultsFor", "A", "", "annotation", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getField", "object", "fieldName", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "getStaticField", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)Ljava/lang/Object;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "fullyQualifiedClassName", "makeFieldVeryAccessible", "", "newInstance", "setField", "type", "fieldNewValue", "setStaticField", "traverseClassHierarchy", "E", "Ljava/lang/Exception;", "Lkotlin/Exception;", "targetClass", "exceptionClass", "insideTraversal", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$InsideTraversal;", "(Ljava/lang/Class;Ljava/lang/Class;Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$InsideTraversal;)Ljava/lang/Object;", "ClassParameter", "InsideTraversal", "StringParameter", "app_debug"})
public final class GSYReflectionHelpers {
    private static final java.util.Map<java.lang.String, java.lang.Object> PRIMITIVE_RETURN_VALUES = null;
    public static final com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers INSTANCE = null;
    
    public final <T extends java.lang.Object>T createNullProxy(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <A extends java.lang.annotation.Annotation>A defaultsFor(@org.jetbrains.annotations.NotNull()
    java.lang.Class<A> annotation) {
        return null;
    }
    
    /**
     * Reflectively get the value of a field.
     *
     * @param object    Target object.
     * @param fieldName The field name.
     * @param <R>       The return type.
     * @return Value of the field on the object.
     *   </R>
     */
    public final <R extends java.lang.Object>R getField(@org.jetbrains.annotations.NotNull()
    java.lang.Object object, @org.jetbrains.annotations.NotNull()
    java.lang.String fieldName) {
        return null;
    }
    
    /**
     * Reflectively set the value of a field.
     *
     * @param object        Target object.
     * @param fieldName     The field name.
     * @param fieldNewValue New value.
     */
    public final void setField(@org.jetbrains.annotations.NotNull()
    java.lang.Object object, @org.jetbrains.annotations.NotNull()
    java.lang.String fieldName, @org.jetbrains.annotations.NotNull()
    java.lang.Object fieldNewValue) {
    }
    
    /**
     * Reflectively set the value of a field.
     *
     * @param type          Target type.
     * @param object        Target object.
     * @param fieldName     The field name.
     * @param fieldNewValue New value.
     */
    public final void setField(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> type, @org.jetbrains.annotations.NotNull()
    java.lang.Object object, @org.jetbrains.annotations.NotNull()
    java.lang.String fieldName, @org.jetbrains.annotations.NotNull()
    java.lang.Object fieldNewValue) {
    }
    
    /**
     * Reflectively get the value of a static field.
     *
     * @param field Field object.
     * @param <R>   The return type.
     * @return Value of the field.
     *   </R>
     */
    public final <R extends java.lang.Object>R getStaticField(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Field field) {
        return null;
    }
    
    /**
     * Reflectively get the value of a static field.
     *
     * @param clazz     Target class.
     * @param fieldName The field name.
     * @param <R>       The return type.
     * @return Value of the field.
     *   </R>
     */
    public final <R extends java.lang.Object>R getStaticField(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> clazz, @org.jetbrains.annotations.NotNull()
    java.lang.String fieldName) {
        return null;
    }
    
    /**
     * Reflectively set the value of a static field.
     *
     * @param field         Field object.
     * @param fieldNewValue The new value.
     */
    public final void setStaticField(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Field field, @org.jetbrains.annotations.NotNull()
    java.lang.Object fieldNewValue) {
    }
    
    /**
     * Reflectively set the value of a static field.
     *
     * @param clazz         Target class.
     * @param fieldName     The field name.
     * @param fieldNewValue The new value.
     */
    public final void setStaticField(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> clazz, @org.jetbrains.annotations.NotNull()
    java.lang.String fieldName, @org.jetbrains.annotations.NotNull()
    java.lang.Object fieldNewValue) {
    }
    
    /**
     * Reflectively call an instance method on an object.
     *
     * @param instance        Target object.
     * @param methodName      The method name to call.
     * @param classParameters Array of parameter types and values.
     * @param <R>             The return type.
     * @return The return value of the method.
     *   </R>
     */
    public final <R extends java.lang.Object>R callInstanceMethod(@org.jetbrains.annotations.NotNull()
    java.lang.Object instance, @org.jetbrains.annotations.NotNull()
    java.lang.String methodName, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
        return null;
    }
    
    /**
     * Reflectively call an instance method on an object on a specific class.
     *
     * @param cl              The class.
     * @param instance        Target object.
     * @param methodName      The method name to call.
     * @param classParameters Array of parameter types and values.
     * @param <R>             The return type.
     * @return The return value of the method.
     *   </R>
     */
    public final <R extends java.lang.Object>R callInstanceMethod(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cl, @org.jetbrains.annotations.NotNull()
    java.lang.Object instance, @org.jetbrains.annotations.NotNull()
    java.lang.String methodName, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
        return null;
    }
    
    /**
     * Reflectively call a static method on a class.
     *
     * @param clazz           Target class.
     * @param methodName      The method name to call.
     * @param classParameters Array of parameter types and values.
     * @param <R>             The return type.
     * @return The return value of the method.
     *   </R>
     */
    public final <R extends java.lang.Object>R callStaticMethod(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> clazz, @org.jetbrains.annotations.NotNull()
    java.lang.String methodName, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
        return null;
    }
    
    /**
     * Load a class.
     *
     * @param classLoader             The class loader.
     * @param fullyQualifiedClassName The fully qualified class name.
     * @return The class object.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<?> loadClass(@org.jetbrains.annotations.NotNull()
    java.lang.ClassLoader classLoader, @org.jetbrains.annotations.NotNull()
    java.lang.String fullyQualifiedClassName) {
        return null;
    }
    
    /**
     * Create a new instance of a class
     *
     * @param cl  The class object.
     * @param <T> The class type.
     * @return New class instance.
     *   </T>
     */
    public final <T extends java.lang.Object>T newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> cl) {
        return null;
    }
    
    /**
     * Reflectively call the constructor of an object.
     *
     * @param clazz           Target class.
     * @param classParameters Array of parameter types and values.
     * @param <R>             The return type.
     * @return The return value of the method.
     *   </R>
     */
    public final <R extends java.lang.Object>R callConstructor(@org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends R> clazz, @org.jetbrains.annotations.NotNull()
    com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
        return null;
    }
    
    private final <R extends java.lang.Object, E extends java.lang.Exception>R traverseClassHierarchy(java.lang.Class<?> targetClass, java.lang.Class<? extends E> exceptionClass, com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.InsideTraversal<R> insideTraversal) {
        return null;
    }
    
    private final void makeFieldVeryAccessible(java.lang.reflect.Field field) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object defaultValueForType(@org.jetbrains.annotations.NotNull()
    java.lang.String returnType) {
        return null;
    }
    
    private GSYReflectionHelpers() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0019\u0010\u0003\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$InsideTraversal;", "R", "", "run", "traversalClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "app_debug"})
    static abstract interface InsideTraversal<R extends java.lang.Object> {
        
        public abstract R run(@org.jetbrains.annotations.NotNull()
        java.lang.Class<?> traversalClass);
    }
    
    /**
     * Typed parameter used with reflective method calls.
     *
     * @param <V> The value of the method parameter.
     *   </V>
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fB\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;", "V", "", "clazz", "Ljava/lang/Class;", "val", "(Ljava/lang/Class;Ljava/lang/Object;)V", "getClazz", "()Ljava/lang/Class;", "getVal", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Companion", "app_debug"})
    public static final class ClassParameter<V extends java.lang.Object> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.Class<? extends V> clazz = null;
        private final V val = null;
        public static final com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter.Companion Companion = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Class<? extends V> getClazz() {
            return null;
        }
        
        public final V getVal() {
            return null;
        }
        
        public ClassParameter(@org.jetbrains.annotations.NotNull()
        java.lang.Class<? extends V> clazz, V val) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\tJ7\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u000b2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\u0010\u000eJ3\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u000b2\u001a\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b\"\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u001a\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b\"\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter$Companion;", "", "()V", "from", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;", "V", "clazz", "Ljava/lang/Class;", "val", "(Ljava/lang/Class;Ljava/lang/Object;)Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;", "fromComponentLists", "", "classes", "values", "([Ljava/lang/Class;[Ljava/lang/Object;)[Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;", "getClasses", "classParameters", "([Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)[Ljava/lang/Class;", "getValues", "([Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$ClassParameter;)[Ljava/lang/Object;", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final <V extends java.lang.Object>com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<V> from(@org.jetbrains.annotations.NotNull()
            java.lang.Class<? extends V> clazz, V val) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>[] fromComponentLists(@org.jetbrains.annotations.NotNull()
            java.lang.Class<?>[] classes, @org.jetbrains.annotations.NotNull()
            java.lang.Object[] values) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Class<?>[] getClasses(@org.jetbrains.annotations.NotNull()
            com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Object[] getValues(@org.jetbrains.annotations.NotNull()
            com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.ClassParameter<?>... classParameters) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * String parameter used with reflective method calls.
     *
     * @param <V> The value of the method parameter.
     *   </V>
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$StringParameter;", "V", "", "className", "", "val", "(Ljava/lang/String;Ljava/lang/Object;)V", "getClassName", "()Ljava/lang/String;", "getVal", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Companion", "app_debug"})
    public static final class StringParameter<V extends java.lang.Object> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String className = null;
        private final V val = null;
        public static final com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.StringParameter.Companion Companion = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getClassName() {
            return null;
        }
        
        public final V getVal() {
            return null;
        }
        
        public StringParameter(@org.jetbrains.annotations.NotNull()
        java.lang.String className, V val) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$StringParameter$Companion;", "", "()V", "from", "Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$StringParameter;", "V", "className", "", "val", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/example/gsygithubappkotlin/common/gsyimageloader/GSYReflectionHelpers$StringParameter;", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final <V extends java.lang.Object>com.example.gsygithubappkotlin.common.gsyimageloader.GSYReflectionHelpers.StringParameter<V> from(@org.jetbrains.annotations.NotNull()
            java.lang.String className, V val) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
}