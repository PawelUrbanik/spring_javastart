package pl.pawel.geoloc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

//    @RequestMapping(method = RequestMethod.GET)
////    public String getMap(Model model, @RequestParam String x, @RequestParam String y)
////    {
////        model.addAttribute("x",x );
////        model.addAttribute("y",y );
////        return "map";
////    }

        @RequestMapping(method = RequestMethod.GET)
    public String getMap(Model model)
    {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(51.76, 19.48, "Wykryte przypadki: 1"));
        pointList.add(new Point(50.82, 17.14, "Wykryte przypadki: 1"));
        model.addAttribute("pointList",pointList );
        return "map";
    }
}
