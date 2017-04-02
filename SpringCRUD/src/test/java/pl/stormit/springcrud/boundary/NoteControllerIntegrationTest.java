package pl.stormit.springcrud.boundary;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import pl.stormit.springcrud.note.entity.NoteEntity;

public class NoteControllerIntegrationTest {

    private WebTarget target;

    @Before
    public void setUp() {
        target = ClientBuilder.newClient().target("http://localhost:47125/SpringCRUD/notes");
    }

//    @Test
    public void integrationTest() {
        testDeleteAll();
        testAdd();
        testUpdate();
        testGetAll();
        testGet();
        testDeleteAll();
        testIsEmpty();
    }

    private void testDeleteAll() {
        List<NoteEntity> notes = target.request().get().readEntity(getNoteType());
        notes.forEach(note -> {
            target.path("/" + note.getId()).request().delete();
        });
    }

    private void testAdd() {
        Response response = target.request().post(Entity.entity(getNote(), MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    private void testUpdate() {
        NoteEntity note = getNoteUpdated();

        Response response = target.path("/{id}").resolveTemplate("id", note.getId()).request().put(Entity.entity(note, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    private void testGetAll() {
        List<NoteEntity> actualNotes = target.request().get().readEntity(getNoteType());

        assertEquals(Arrays.asList(getNoteUpdated()), actualNotes);
    }

    private void testGet() {
        NoteEntity note = getNoteUpdated();
        NoteEntity actualNote = target.path("/" + note.getId()).request().get().readEntity(NoteEntity.class);

        assertEquals(note, actualNote);
    }

    private void testIsEmpty() {
        List<NoteEntity> actualNotes = target.request().get().readEntity(getNoteType());

        assertEquals(0, actualNotes.size());
    }

    private NoteEntity getNote() {
        return new NoteEntity(1, "Java");
    }

    private NoteEntity getNoteUpdated() {
        return new NoteEntity(1, "Java8");
    }

    private GenericType<List<NoteEntity>> getNoteType() {
        GenericType<List<NoteEntity>> entityType = new GenericType<List<NoteEntity>>() {
        };

        return entityType;
    }
}
