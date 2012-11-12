import java.lang.reflect.*;
import java.util.*;

import javax.swing.DefaultListModel;

@SuppressWarnings("unused")

public class ObjectToAdd {
	private int TYPE;
	private Object theObject;
	public DefaultListModel<ObjectToAdd> field;
	public Vector<Object> value;
	public ObjectToAdd[] objectArray;
	private int ARRAY_INDEX;
	List<ObjectToAdd> objectList;
	
	public ObjectToAdd(int newType) {
		this.TYPE = newType;
		if (this.TYPE > 0) {
			theObject = this;
		}
		this.field = new DefaultListModel<ObjectToAdd>();
		this.value = new Vector<Object>();
		objectList = new ArrayList<ObjectToAdd>();
		
		this.ARRAY_INDEX = 0;
	}
	
	public Object getObject() {
		return this.theObject;
	}
	public void setObject(Object obj) {
		this.theObject = obj;
	}
	public int getType() {
		return this.TYPE;
	}

	private void setFieldValue(ObjectToAdd Value,int index) {
		this.field.setElementAt(Value, index);
	}
	
	void addPrimitiveToArray(ObjectToAdd object) {
		
			objectArray[ARRAY_INDEX++] = object;
		
	}
	
	 void addObjectToArray(ObjectToAdd object) {
		
			objectArray[ARRAY_INDEX++] = object;
		
	}
	public ObjectToAdd getArrayObject(int index) {
		return objectArray[index];
	}
	public void addField(ObjectToAdd Value) throws WrongTypeException{

			field.addElement(Value);
		
	}
	
	public ObjectToAdd getField(int index) {
		return this.field.elementAt(index);
	}
	
	public void addFieldValue(Object Value) throws WrongTypeException{
		
			this.value.add(Value);
	
	}
	
	public void addArray(int length) {
		objectArray = new ObjectToAdd[length];
	}
	
	public void makeChar(char Value){
		theObject = Value;
	}

	public void makeByte(byte Value){
		theObject = Value;
	}
	
	public int getObjectArrayLength() {
		if (objectArray != null) {
		return objectArray.length;
		}
		return 0;
	}

	public void makeShort(short Value){
		theObject = Value;
	}

	public void makeInt(int Value){
		theObject = Value;
	}

	public void makeLong(long Value){
		theObject = Value;
	}

	public void makeFloat(float Value){
		theObject = Value;
	}

	public void makeDouble(double Value){
		theObject = Value;
	}

	public void makeBoolean(boolean Value){
		theObject = Value;
	}

	public void makeVoid(){
		theObject = null;
	}
	public void addToList(ObjectToAdd object) {
		objectList.add(object);
	}
	
	public ObjectToAdd getFromListAt(int i) {
		return objectList.get(i);
	}
}
