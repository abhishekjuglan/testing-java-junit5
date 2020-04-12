package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class MapModel implements Model{

	public Map<String,Object> map ;
	
	@Override
	public void addAttribute(String key, Object o) {
		if(map==null)
			map = new HashMap<String,Object>();
		map.put(key,o);
	}

	@Override
	public void addAttribute(Object o) {
		// TODO Auto-generated method stub
		
	}

}
