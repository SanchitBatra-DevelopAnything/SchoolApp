package com.sbgu.admissionservice.demo.Service;

import com.sbgu.admissionservice.demo.Entity.AdmissionRequest;
import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;
import com.sbgu.admissionservice.demo.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolsServiceImpl implements SchoolsService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> getAllSchools() throws SchoolNotFoundException {
       List<School> sl =  this.schoolRepository.findAll();

       if(sl.size() == 0)
       {
           throw new SchoolNotFoundException();
       }
//       for(int i=0;i<sl.size();i++)
//       {
//           sl.get(i).setAdmissionRequests(null);
//       }
       return sl;
    }

    @Override
    public List<BasicSchoolData> getAllSchoolsBasicData() throws SchoolNotFoundException {
        List<BasicSchoolData> basic_data = schoolRepository.getAllSchoolsBasicData();
        if(basic_data.size() == 0)
        {
            throw new SchoolNotFoundException();
        }
        return basic_data;
    }

    @Override
    public List<AdmissionRequest> getAllAdmissionRequests(Long schoolId) {
        return null;
    }
}
