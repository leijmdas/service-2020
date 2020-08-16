//package ytb.common.testcase;
//
//import org.bson.types.ObjectId;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.test.context.junit4.SpringRunner;
//import ytb.common.SpringBootCommon;
//import ytb.common.context.model.Ytb_Model;
//
//import java.util.List;
////spring:
////        application:
////        name: ytb_common
////        main:
////        allow-bean-definition-overriding: true
////        groovy:
////        template:
////        check-template-location: false
////
////        data:
////        mongodb:
////        host: 192.168.4.162
////        port: 27017
////        authentication-database: admin
////        database: project
////        username: root
////        password: password
////        #uri: mongodb://root:123@192.168.4.162:27017/?authSource=admin&authMechanism=SCRAM-SHA-1"
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootCommon.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//
//public class TestSpring {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Document(collection = "project")
//    public static class Project extends Ytb_Model {
//        @Id
//        private String id;
//        private String title;
//        private String description;
//        private String likes;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getLikes() {
//            return likes;
//        }
//
//        public void setLikes(String likes) {
//            this.likes = likes;
//        }
//
//
//
//    }
//    public Project getOne(ObjectId id) {
//        return mongoTemplate.findById(id, Project.class);
//    }
//
//    @Test
//    public void test0001_sapiLogin() {
//        Project p= getOne(new ObjectId("5f1f3339d68bdcd028bf9d72"));
//        System.out.println(p);
//    }
//    @Test
//    public void test0002_save() {
//        Project pp=new Project();
//        //pp.setId("1");
//        pp.setTitle("12");
//        pp.setLikes("11");
//        pp.setDescription("22");
//        Project p= mongoTemplate.save(pp);
//        System.out.println(p);
//    }
//    @Test
//    public void test0003_findAll() {
//        test0002_save();
//        List<Project> ps = mongoTemplate.findAll(Project.class);
//        System.out.println(ps);
//        System.out.println(ps.size());
//    }
//    @Test
//    public void test0004_findAllSkip() {
//        //org.springframework.data.domain.Sort s;
//        test0002_save();
//        Query q = new Query();
//        q.skip(0).limit(211);
//        //q.getSortObject().append("title", "asc");
//        q.with(Sort.by(Sort.Order.asc("title")));
//        List<Project> ps = mongoTemplate.find(q, Project.class);
//        System.out.println(ps);
//        System.out.println(mongoTemplate.count(q, Project.class));
//    }
//
//}
//
