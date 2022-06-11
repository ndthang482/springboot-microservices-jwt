package savvycom.major.service.impl;

import savvycom.major.domain.entity.Major;
import savvycom.major.repository.MajorRepository;
import savvycom.major.service.IMajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService {
    private final MajorRepository majorRepository;

    @Override
    public Major save(Major major) {
        return majorRepository.save(major);
    }

    @Override
    public void delete(Major major) {
        majorRepository.deleteById(major.getId());
    }

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Major findById(Integer id) {
        return majorRepository.findById(id).orElse(null);
    }

    @Override
    public Major findByCode(String code) {
        return majorRepository.findByCode(code).orElse(null);
    }
}
