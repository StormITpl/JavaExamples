package pl.stormit.springcrud.note.control;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.stormit.springcrud.note.entity.NoteEntity;

@Service
public class NoteService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<NoteEntity> getNotes() {
        return jdbcTemplate.query("SELECT * FROM NoteEntity", new BeanPropertyRowMapper<>(NoteEntity.class));
    }

    public NoteEntity getNote(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM NoteEntity WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(NoteEntity.class));
    }

    public void addNote(NoteEntity noteEntity) {
        String sqlInsert = "INSERT INTO NoteEntity (ID, NAME) VALUES (?, ?)";

        jdbcTemplate.update(sqlInsert, new Object[]{noteEntity.getId(), noteEntity.getName()});
    }

    public void updateNote(long id, NoteEntity noteEntity) {
        String sqlUpdate = "UPDATE NoteEntity SET NAME = ? WHERE id = ?";

        jdbcTemplate.update(sqlUpdate, noteEntity.getName(), noteEntity.getId());
    }

    public void deleteNote(long id) {
        String sqlDelete = "DELETE FROM NoteEntity WHERE id = ?";

        jdbcTemplate.update(sqlDelete, id);
    }

}
