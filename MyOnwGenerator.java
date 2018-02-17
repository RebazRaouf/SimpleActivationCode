package kurdishDev;

public class MyOnwGenerator {
	
	String currentChar;
	
	public String getEncodedCode(String input)throws Exception{
		if(!Main.isPackageTrue())throw new Error();
        String result = input;
        StringBuilder data = new StringBuilder();
        if (result.length() >= 10) {
            result = getSerialSize(result, 10);
        } else if (result.length() == 8) {
            result = getSerialSize(result, 8);
        } else {
           throw new Exception("Error");
        }

        int n = result.length() - 1;
        data.append(result.charAt(0));
        data.append(result.charAt(2));
        for (int i = n; i > 0; i--) {
            data.append(result.charAt(i));
        }
        data.append(result.charAt(6));
        data.append(result.charAt(n));
        result = data.toString()+"-V1";
        Main.main.generatedSerail = result;
        return result;
    }
	
	private String getSerialSize(String input, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += String.valueOf(input.charAt(i));
        }
        return result;
    }
	
	public String getChared(int type,String character){
		this.currentChar = character;
		if(type==1 || type==2){
			return firstChar();
		}
		if(type==3){
			return thirdChar();
		}
		if(type==4){
			return lastChar();
		}
		return null;
	}

	String[] fisrtCharacter = new String[]{"A","C","B","E","H","K","N","Q","U","X"};
	String[] thirdCharacter = new String[]{"9","8","7","6","5","4","3","2","1","0"};
	String[] lastCharacter = new String[]{"A","B","C","D","E","F","G","H","I","J"};
	int[] index = new int[]{2,4,6,8};
	
	private String firstChar() {
		return fisrtCharacter[Integer.valueOf(currentChar)];
	}
	
	private String thirdChar() {
		return thirdCharacter[Integer.valueOf(currentChar)];
	}
	
	private String lastChar() {
		return lastCharacter[Integer.valueOf(currentChar)];
	}
	
	public String getFirstActivationCode(){
		StringBuilder str = new StringBuilder();
		for(int i=0;i<index.length;i++){
			str.append(Main.main.generatedSerail.charAt(index[i]));
		}
		return str.toString();
	}
	

}
