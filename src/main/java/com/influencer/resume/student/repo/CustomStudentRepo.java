package com.influencer.resume.student.repo;

import com.influencer.resume.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Repository //Bu klass bazaya qosulub islemek ucundur
@Component
public class CustomStudentRepo {// embedded tomcat

    private final EntityManager em;// Bazaya qosulub islemek ucun bize lazimdir

    public CustomStudentRepo(final EntityManager em) {
        this.em = em;
    }

    public List<Student> getList(String name,
                                 String surname,
                                 String email,
                                 Integer universityId,
                                 Integer age){

        CriteriaBuilder cb = em.getCriteriaBuilder();//elde edilir -(like, equal, and) düzəldən fabrikdir.
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);//Sorğu obyekti yaradılır (qaytardığı tip üzrə)
        Root<Student> root = cq.from(Student.class);//select * from student
        //FROM hissəsi (hansı Entity üzərində işləyəcəyimizi təyin edirik)

        List<Predicate> predicates = new ArrayList<>();
        if(name!=null && !name.isEmpty()){//root.get("name") = student.name
            predicates.add(cb.like(root.get("firstName"), "%" + name + "%"));
        }
        if(surname!=null && !surname.isEmpty()){
            predicates.add(cb.like(root.get("surname"), "%" + surname + "%"));
        }
        if(email!=null && !email.isEmpty()){
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }
        if(age!=null){
            predicates.add(cb.equal(root.get("age"),  age));
        }
        if(universityId!=null){
            predicates.add(cb.equal(root.get("university").get("id"), universityId));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);//where name like %name% and surname %surname%

        cq.select(root);//select * from student where name like %name% and surname %surname%

        return em.createQuery(cq).getResultList();
    }
}