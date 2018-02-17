package kurdishDev;

public class DataStructure {

	private String firstChar;
	private String secondChar;
	private String thirdChar;
	private String lastChar;
	private String firstUserChar;
	private String secondUserChar;
	private String thirdUserChar;

	public void setChar(int i,String str) {
		switch (i) {
		case 1:
			firstChar = str;
			break;
		case 2:
			secondChar = str;
			break;
		case 3:
			thirdChar = str;
			break;
		case 4:
			lastChar = str;
			break;
		case 5:
			firstUserChar = str;
			break;
		case 6:
			secondUserChar = str;
			break;
		case 7:
			thirdUserChar = str;
			break;
		default:
			break;
		}
	}
	

	public String getChar(int i) {
		switch (i) {
		case 1:
			return firstChar;
		case 2:
			return secondChar;
		case 3:
			return thirdChar;
		case 4:
			return lastChar;
		case 5:
			return firstUserChar;
		case 6:
			return secondUserChar;
		case 7:
			return thirdUserChar;
		default:
			throw new Error();
		}
	}
	
	int[] index = new int[]{4,3,2,1,1,3,2};
	
	public String getLastActivationCode(){
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index.length;i++){
			builder.append(getChar(index[i]));
		}
		builder.reverse();
		return builder.toString();
	}

}
