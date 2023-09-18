package util;

import java.util.ArrayList;
import java.util.List;

import com.bms.dto.Screen;
import com.bms.dto.Theatre;
import com.bms.dto.Theatres;
import com.bms.entity.ScreenEntity;
import com.bms.entity.TheatreEntity;

public class ObjectMapper {

	public static Theatre mapTheatreEntityToDTO(TheatreEntity entity) {
		Theatre theatre = new Theatre();
		theatre.setTheaterID(entity.getTheaterID());
		theatre.setCity(entity.getCityName());
		theatre.setTheaterName(entity.getTheaterName());
		List<Screen> screens = new ArrayList<>();
		for (ScreenEntity screenEntity : entity.getScreens()) {
			Screen screen = new Screen();
			screen.setScreenid(screenEntity.getScreenID());
			screen.setTotalSeats(screenEntity.getScreenSeats());
			screens.add(screen);

		}
		theatre.setScreens(screens);
		return theatre;
	}

	public static Theatres mapTheatreEntityToDTO(List<TheatreEntity> theaterEntityList) {
		Theatres theatres = new Theatres();
		List<Theatre> theatreList = new ArrayList<>();
		for (TheatreEntity theatreEntity : theaterEntityList) {
			theatreList.add(mapTheatreEntityToDTO(theatreEntity));
		}
		theatres.setTheatres(theatreList);
		return theatres;
	}

}
