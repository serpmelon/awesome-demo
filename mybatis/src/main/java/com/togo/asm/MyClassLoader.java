package com.togo.asm;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:52 下午 2020/4/28
 **/
public class MyClassLoader extends ClassLoader {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "com/togo/asm/TestMapper", null, "java/lang/Object", null);

        cw.visitSource("TestMapper.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "queryById", "(Ljava/lang/Integer;)Ljava/util/Map;", "(Ljava/lang/Integer;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;", null);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public Class<?> defineClass(String name, byte[] b) {
        // ClassLoader是个抽象类，而ClassLoader.defineClass 方法是protected的
        // 所以我们需要定义一个子类将这个方法暴露出来
        return super.defineClass(name, b, 0, b.length);
    }
}
