package com.design.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * The problem with serialized singleton class is that whenever we deserialize
 * it, it will create a new instance of the class.readResolve() to get the same
 * instance
 * 
 * @author Deepesh
 * 
 */
public class SingletonSerializedTest {

	public static void main(String[] args) {
		Singleton instanceOne = Singleton.getInnerInstance();

		try {
			// serialize
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
					"filename.ser"));

			out.writeObject(instanceOne);
			out.close();

			// deserialize
			ObjectInput in = new ObjectInputStream(new FileInputStream(
					"filename.ser"));
			Singleton instanceTwo = (Singleton) in.readObject();
			in.close();

			System.out.println("instanceOne : " + instanceOne.hashCode());
			System.out.println("instanceTwo : " + instanceTwo.hashCode());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
