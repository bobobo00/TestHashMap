package cn.test.mycollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自定义实现HashMap的方法 HashMap：链表+数组
 * 
 * @author dell
 *
 */

public class MyHashMap<K,V> {
	MapNode[] table;
	int size;

	public MyHashMap() {
		table = new MapNode[16];
	}
	
	private int myHash(int v) {
		return v & (table.length - 1);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				sb.append(table[i]);
				if (table[i].next != null) {
					MapNode temp = table[i].next;
					while (temp != null) {
						sb.append(temp);
						temp = temp.next;
					}
				}
			}
		}
		sb.append('}');
		return sb.toString();
	}

	public void put(K key,V value) {
		MapNode node = new MapNode(key, value);
		node.hash = myHash(key.hashCode());
		if (table[node.hash] == null) {
			table[node.hash] = node;
			size++;
		} else {
			if (table[node.hash].k.equals(key)) {
				table[node.hash].v = value;
				return;
			}
			MapNode temp = table[node.hash];
			while (temp.next != null && (!temp.k.equals(key))) {
				temp = temp.next;
				if (temp.k.equals(key)) {
					temp.v=value;
					return;
				}
			}
			temp.next = node;
			size++;
		}
	}

	public MapNode search(K key) {
		int hash = myHash(key.hashCode());
		if (table[hash] == null) {
			//throw new RuntimeException("不存在key为" + key + "的键值对");
			return null;
		}
		MapNode temp = table[hash];
		while (temp != null) {
			if (key.equals(temp.k)) {
				return temp;
			}
			temp=temp.next;
		}
		return null;
	}

	public V get(K key) {
		MapNode temp = this.search(key);
		if (temp != null) {
			return (V)temp.v;
		}
		return null;
	}
	
	public V getOrDefault(K key,V value) {
		MapNode temp = this.search(key);
		if (temp != null) {
			return (V)temp.v;
		}
		return (V)value;
	}

	public void set(K key,V value) {
        MapNode temp=this.search(key);
        if(temp!=null) {
        	temp.v=value;
        }
	}
	public void remove(K key) {
		int hash = myHash(key.hashCode());
		if (table[hash] == null) {
			throw new RuntimeException("不存在key为" + key + "的键值对");
		}
		if(table[hash].next==null&&table[hash].k.equals(key)) {
			table[hash]=null;
			size--;
			return;
		}
		MapNode node = table[hash];
		while(!(node.next.k.equals(key))){
			node=node.next;
			if(node.next==null) {
				break;
			}
		}
		if(node.next!=null) {
			node.next=node.next.next;
			size--;
		}else {
			throw new RuntimeException("不存在key为" + key + "的键值对");
		}
			
	}
	
	public Set<K> keySet(){
		Set<K> set=new HashSet<>();
		for(int i=0;i<table.length&&table[i]!=null;i++) {
			/*if(table[i]==null) {
				continue;
			}*/
			MapNode node=table[i];
			while(node!=null) {
				set.add((K)node.k);
				node=node.next;
				}
			}
		return set;
	}
	public List<V> valuesSet(){
		List<V> list=new ArrayList<>();
		for(int i=0;i<table.length;i++) {
		if(table[i]==null) {
			continue;
			}
			MapNode node=table[i];
			while(node!=null) {
				list.add((V)node.v);
				node=node.next;
			}
		}
	return list;
  }
	/*public Set<Map.Entry<K, V>> entrySet(){
		Set<Map.Entry<K, V>> set=new HashSet<>();
		for(int i=0;i<table.length;i++) {
			if(table[i]==null) {
				continue;
				}
			if(table[i].next==null) {
				Map<K,V> map=new HashMap<>();
				map.put((K)table[i].k, (V)table[i].v);
				set.add(map.entrySet());
			}else {
				MapNode node=table[i];
				while(node!=null) {
					list.add((V)node.v);
					node=node.next;
				}
			}
		}
		return set;
	}*/
    public boolean containsKey(K key) {
    	if(this.search(key)!=null) {
    		return true;
    	}
    	return false;
    }
	public boolean containsValue(V value) {
		for(int i=0;i<table.length;i++) {
			if(table[i]==null) {
				continue;
				}
			MapNode node=table[i];
			while(node!=null) {
				if(node.v.equals(value)) {
					return true;
				}
					node=node.next;
			}
		}
		return false;
	}
	

	

	public static void main(String[] args) {
		MyHashMap<Integer,String> map = new MyHashMap<>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(4, "ccc");
		map.put(5, "ddd");
		map.set(2, "666");
		map.put(6, "aaa");
		System.out.println(map.size);
		System.out.println(map.keySet());
		System.out.println(map.valuesSet());
		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue("cc"));
		System.out.println(map);
		
		// System.out.println(map.get(1));
		// System.out.println(map.get(5));

	}

}
