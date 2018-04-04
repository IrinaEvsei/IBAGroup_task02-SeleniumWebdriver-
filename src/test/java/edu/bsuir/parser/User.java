package edu.bsuir.parser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="user")
public class User {
    private List<Role> role;

    @XmlElement(name="role")
    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> roleList) {
        this.role = roleList;
    }
}
