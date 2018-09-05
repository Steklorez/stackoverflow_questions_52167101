import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Person {
    private String name;
    private Integer age;
    private List<String> friends;
    private String dob;
    private Education education;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Config1 config1;
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Config2 config2;
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Config3 config3;

    public Config1 getConfig1ByTemplate() {
        if (getConfig1() != null) return getConfig1();
        Config1 conf = new Config1();
        conf.setAge(getAge());
        conf.setDob(getDob());
        conf.setEducation(getEducation());
        conf.setFriends(getFriends());
        conf.setName(getName());
        this.config1 = conf;
        return getConfig1();
    }

     public Config2 getConfig2ByTemplate() {
        if (getConfig2() != null) return getConfig2();
        Config2 conf = new Config2();
        conf.setEducationalInfoFromTemplate(education);
        conf.setPersonalInfoFromTemplate(name, age, friends);
        this.config2 = conf;
        return getConfig2();
    }

     public Config3 getConfig3ByTemplate() {
        if (getConfig3() != null) return getConfig3();
        Config3 conf = new Config3();
        conf.setEducationalInformation(education);
        conf.setPersonalInformation(name, age);
        this.config3 = conf;
        return getConfig3();
    }

    @Getter
    @Setter
    private class Config1 {
        private String name;
        private Integer age;
        private Education education;
        private List<String> friends;
        private String dob;
    }

    @Getter
    @Setter
    private class Config2 {
        private PersonalInfo personalInfo;
        private EducationalInfo educationalInfo;

        private void setEducationalInfoFromTemplate(Education education) {
            this.educationalInfo = new EducationalInfo(education);
        }

        private void setPersonalInfoFromTemplate(String name, Integer age, List<String> friends) {
            this.personalInfo = new PersonalInfo(name, age, friends);
        }

        @Getter
        @Setter
        private class PersonalInfo {
            private String name;
            private Integer age;
            private List<String> friends;

            PersonalInfo(String name, Integer age, List<String> friends) {
                this.name = name;
                this.age = age;
                this.friends = friends;
            }
        }

        @Getter
        @Setter
        private class EducationalInfo {
            private String college;
            private String study;
            private Double grade;

            EducationalInfo(Education education) {
                this.college = education.college;
                this.study = education.study;
                this.grade = education.grade;
            }
        }
    }

    @Getter
    @Setter
    private class Config3 {
        private PersonalInformation personalInformation;
        private EducationalInformation educationalInformation;

        void setPersonalInformation(String name, Integer age) {
            this.personalInformation = new PersonalInformation(name, age);
        }

        void setEducationalInformation(Education education) {
            this.educationalInformation = new EducationalInformation(education);
        }


        @Getter
        @Setter
        private class PersonalInformation {
            private String nameOfEmployee;
            private Integer ageOfEmployee;

            PersonalInformation(String name, Integer age) {
                this.nameOfEmployee = name;
                this.ageOfEmployee = age;
            }
        }

        @Getter
        @Setter
        private class EducationalInformation {
            private String college;
            private String study;

            EducationalInformation(Education education) {
                this.college = education.getCollege();
                this.study = education.getStudy();
            }
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    private class Education {
        private String college;
        private String study;
        private Double grade;
    }
}
