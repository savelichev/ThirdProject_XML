
package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "danceMain", propOrder = {
        "type",
        "scene",
        "numberOfDancers",
        "music",
        "dancers",
        "number"
})
public class DanceMain {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DanceType type;
    @XmlElement(required = true)
    protected String scene;
    protected int numberOfDancers;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MusicType music;
    @XmlElement(required = true)
    protected DancerInfo dancers;
    protected int number;
    @XmlAttribute(name = "title")
    protected String title;
    @XmlAttribute(name = "id")
    protected Integer id;

    public DanceType getType() {
        return type;
    }

    public void setType(DanceType value) {
        this.type = value;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String value) {
        this.scene = value;
    }

    public int getNumberOfDancers() {
        return numberOfDancers;
    }

    public void setNumberOfDancers(int value) {
        this.numberOfDancers = value;
    }

    public MusicType getMusic() {
        return music;
    }

    public void setMusic(MusicType value) {
        this.music = value;
    }

    public DancerInfo getDancers() {
        if (dancers==null){
            dancers = new DancerInfo();
        }
        return dancers;
    }

    public void setDancers(DancerInfo value) {
        this.dancers = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int value) {
        this.number = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    @Override
    public String toString() {
        return "DanceMain{" +
                "type=" + type +
                ", scene='" + scene + '\'' +
                ", numberOfDancers=" + numberOfDancers +
                ", music=" + music +
                ", dancers=" + dancers.getDancer() +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
