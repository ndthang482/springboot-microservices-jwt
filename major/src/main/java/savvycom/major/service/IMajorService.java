package savvycom.major.service;

import savvycom.major.domain.entity.Major;

import java.util.List;

public interface IMajorService {
    Major save(Major major);
    void delete(Major major);
    List<Major> findAll();
    Major findById(Integer id);
    Major findByCode(String code);
}