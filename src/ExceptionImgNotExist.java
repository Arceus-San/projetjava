
public class ExceptionImgNotExist extends RuntimeException {

	public ExceptionImgNotExist(){
		super("Aucune image ne correspond à ce nom");
	}
}
