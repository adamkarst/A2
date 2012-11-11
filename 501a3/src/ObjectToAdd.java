import java.lang.reflect.*;
import java.util.*;

@SuppressWarnings("unused")

public class ObjectToAdd {
	private int TYPE;
	private Object theObject;
	public Vector<Object> field;
	public Vector<Object> value;
	private ObjectToAdd[] objectArray;
	private int ARRAY_INDEX;
	private List<Object> objectList;
	
	public ObjectToAdd(int newType) {
		this.TYPE = newType;
		this.field = new Vector<Object>();
		this.value = new Vector<Object>();
		objectList = new ArrayList<Object>();
		this.theObject = new Object();
		this.ARRAY_INDEX = 0;
	}
	
	
	public int getType() {
		return this.TYPE;
	}

	private void setFieldValue(Object Value,int index) {
		this.field.setElementAt(Value, index);
	}
	
	private void addPrimitiveToArray(ObjectToAdd object) {
		if (this.TYPE == 3) {
			objectArray[ARRAY_INDEX++] = object;
		}
	}
	
	private void addObjectToArray(ObjectToAdd object) {
		if (this.TYPE == 4) {
			objectArray[ARRAY_INDEX++] = object;
		}
	}
	
	public void addField(Object Value) throws WrongTypeException{

			this.field.add(Value);
		
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
	public void addToList(Object object) {
		objectList.add(object);
	}
	
	public Object getFromListAt(int i) {
		return objectList.get(i);
	}
}
