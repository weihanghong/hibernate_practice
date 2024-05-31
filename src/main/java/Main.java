import com.hong.model.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Session session = connectToDB();
        Transaction transaction = session.beginTransaction();
        Hospital hospitalA = new Hospital("HospitalA", "AddressA");
        Hospital hospitalB = new Hospital("HospitalB", "AddressB");
        Doctor doctorA = new Doctor("Dr.A", hospitalA);
        Doctor doctorB = new Doctor("Dr.B", hospitalA);
        Doctor doctorC = new Doctor("Dr.C", hospitalB);
        Doctor doctorD = new Doctor("Dr.D", hospitalB);
        Specialty specialtyA = new Specialty("SpecialtyA", doctorA);
        Specialty specialtyB = new Specialty("SpecialtyB", doctorA);
        Date dateA = new Date();
        dateA.setTime(dateA.getTime() + 10000000);
        Date dateB = new Date();
        dateB.setTime(dateB.getTime() + 20000000);
        Date dateC = new Date();
        dateC.setTime(dateC.getTime() + 30000000);
        Date dateD = new Date();
        dateD.setTime(dateD.getTime() + 40000000);
        ScheduleProfile spA = new ScheduleProfile(ScheduleProfile.visitType.SICK, dateA);
        ScheduleProfile spB = new ScheduleProfile(ScheduleProfile.visitType.ANNUAL, dateB);
        ScheduleProfile spC = new ScheduleProfile(ScheduleProfile.visitType.CHECKUP, dateC);
        ScheduleProfile spD = new ScheduleProfile(ScheduleProfile.visitType.CONSULT, dateD);
        doctorA.setSchedule(spA);
        doctorB.setSchedule(spB);
        doctorC.setSchedule(spC);
        doctorD.setSchedule(spD);
        Patient patientA = new Patient("PatientA", "AddressA");
        Patient patientB = new Patient("PatientB", "AddressB");
        Patient patientC = new Patient("PatientC", "AddressC");
        Patient patientD = new Patient("PatientD", "AddressD");
        Set<Patient> patientsA = new HashSet<>();
        patientsA.add(patientA);
        patientsA.add(patientB);
        Set<Patient> patientsB = new HashSet<>();
        patientsB.add(patientC);
        patientsB.add(patientD);
        Set<Patient> patientsC = new HashSet<>();
        patientsC.add(patientA);
        patientsC.add(patientC);
        Set<Patient> patientsD = new HashSet<>();
        patientsD.add(patientB);
        patientsD.add(patientD);
        doctorA.setPatientSet(patientsA);
        doctorB.setPatientSet(patientsB);
        doctorC.setPatientSet(patientsC);
        doctorD.setPatientSet(patientsD);
        session.persist(hospitalA);
        session.persist(hospitalB);
        session.persist(doctorA);
        session.persist(doctorB);
        session.persist(doctorC);
        session.persist(doctorD);
        session.persist(specialtyA);
        session.persist(specialtyB);
        session.persist(spA);
        session.persist(spB);
        session.persist(spC);
        session.persist(spD);
        session.persist(patientA);
        session.persist(patientB);
        session.persist(patientC);
        session.persist(patientD);
        transaction.commit();
        session.close();
    }

    private static Session connectToDB(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        return factory.openSession();
    }
}
