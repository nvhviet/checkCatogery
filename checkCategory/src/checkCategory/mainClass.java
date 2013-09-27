package checkCategory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainClass {
	public static void main(String[] agrs){
		try {				
			//System.out.println("Init checking...");
			String strInput = agrs[0];// "1-9,48-50,6,9";
			String strPage = agrs[1]; //"0;0;0;0;0;0;0;0;0;0";			
			//Processing strInput======================
			Pattern pt = Pattern.compile("\\d+\\-\\d+");
			Matcher mt = pt.matcher(strInput);		
			while(mt.find()){			
				String strProcess = "";
				String strFind = mt.group();
				//System.out.println(strFind);
				String[] param = strFind.split("-");
				int begin = Integer.parseInt(param[0]);
				int end = Integer.parseInt(param[1]);
				for(int i = begin; i <= end; i++){
					strProcess+="," + String.valueOf(i);
				}	
				strProcess = strProcess.substring(1);
				strInput = strInput.replace(strFind, strProcess);
			}
			//System.out.println("Process: " + strInput);
			strInput = "," + strInput + ",";
			int allPage = strPage.split(";").length;
			String outPut = "";
			for(int i = 1; i <=allPage; i++){
				String check = "," + String.valueOf(i) + ",";
				if(!strInput.contains(check)){
					//JOptionPane.showMessageDialog (null, "Missing page " + String.valueOf(i) + "\nPlease check again", "IDEAS-ANZ", JOptionPane.WARNING_MESSAGE);
					outPut+="," + String.valueOf(i);			
				}
			}
			if(outPut.isEmpty()){
				for(String outPage : strInput.split(",")){
					try {
						int check = Integer.parseInt(outPage);
						if(check>allPage){						//
							outPut+="," + outPage;			
						}
					} catch (Exception e) {
						// TODO: handle exception
						//Not anumber
					}					
				}
				if(outPut.isEmpty()){
					System.out.println("0");
				}else{
					System.out.println("+ " + outPut.substring(1));
				}
			}else{				
				System.out.println("- " + outPut.substring(1));
			};			
			//End Processing strInput==================		
			//System.out.println("Finished checking...");
			//System.out.println("testCheckin");
			//System.out.println("testCheckin1");
			//System.out.println("testCheckin2");
			System.out.println("testCheckin11");
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO: handle exception
		}
	}
}
