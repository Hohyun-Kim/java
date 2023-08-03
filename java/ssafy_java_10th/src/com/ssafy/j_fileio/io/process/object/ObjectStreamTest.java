package com.ssafy.j_fileio.io.process.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
//        write();
        read();
    }

    private static File target = new File("c:/Temp/objPerson.dat");

    private static void write() {
        Person person = new Person("홍길동2", "pass1234", "123-456", "seoul");
        // TODO: person을 target에 저장하시오.
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))){
        	out.writeObject(person);
        	System.out.println(("저장 완료"));
        }catch(IOException e) {
        	e.printStackTrace();
        }

        // END
    }

    private static void read() {
        // TODO: target에서 person을 읽어서 내용을 출력하시오.
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(target))) {
    		Object obj = in.readObject();
    		System.out.println((obj));
    		System.out.println(("복구 완료"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        // END
    }
}
