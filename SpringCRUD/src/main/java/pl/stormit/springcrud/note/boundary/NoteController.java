package pl.stormit.springcrud.note.boundary;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.stormit.springcrud.note.control.NoteService;
import pl.stormit.springcrud.note.entity.NoteEntity;

@Controller
@Path("notes")
@Produces(MediaType.APPLICATION_JSON)
public class NoteController {

    private final Logger LOG = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;

    @GET
    public List<NoteEntity> getNotes() {
        if (LOG.isInfoEnabled()) {
            LOG.info("Get all notes");
        }
        return noteService.getNotes();
    }

    @GET
    @Path("{id}")
    public NoteEntity getNote(@PathParam("id") long id) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Get note by id: {}", id);
        }
        return noteService.getNote(id);
    }

    @POST
    public Response addNote(NoteEntity noteEntity) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Add new note: {}", noteEntity);
        }
        noteService.addNote(noteEntity);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateNote(@PathParam("id") long id, NoteEntity noteEntity) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Update note [{}]: {}", id, noteEntity);
        }
        noteService.updateNote(id, noteEntity);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Delete note: {}", id);
        }
        noteService.deleteNote(id);
        return Response.ok().build();
    }
}
