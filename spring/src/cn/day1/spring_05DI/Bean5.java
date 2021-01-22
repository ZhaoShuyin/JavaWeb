package cn.day1.spring_05DI;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 数组集合参数设置值
 */
public class Bean5 {
    private String[] strs;
    private Set<String> set;
    private List<String> list;
    private Map<String, String> map;
    private Properties props;

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

}
