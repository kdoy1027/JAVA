
// HashMap<키, 값>
// 키는 중복 x 하고 값은 중복 가능함.
// 받을 때는 

package ch17;

import java.util.HashMap;
import java.util.Iterator;

public class MapEx {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("자신맨", "010-1111-1111");
		hm.put("로제", "010-2222-2222");
		hm.put("bts", "010-1111-1111");
	
		
		Iterator<String> it = hm.keySet().iterator(); 
		// 키로 가져와서 it 객체에 iterator 를 통해 담을거야.
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		
		
		
		
	}

}
