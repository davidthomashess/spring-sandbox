package com.sandbox.mariokart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.repository.PlayerRepository;
import com.sandbox.mariokart.repository.TrackRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class MarioKartApplication implements CommandLineRunner {

    private PlayerRepository playerRepository;
    private TrackRepository trackRepository;

    public static void main(String[] args) {
        SpringApplication.run(MarioKartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Player[] players = new Player[] {
                new Player("Bowser", "EVIL"),
                new Player("D.K.", "MIXED"),
                new Player("Luigi", "GOOD"),
                new Player("Mario", "GOOD"),
                new Player("Peach", "GOOD"),
                new Player("Toad", "GOOD"),
                new Player("Wario", "EVIL"),
                new Player("Yoshi", "GOOD")

        };

        for (int i = 0; i < players.length; i++) {
            playerRepository.save(players[i]);
        }

        Track[] tracks = new Track[] {
                new Track("Banshee Boardwalk", "NORMAL",
                        "Banshee Boardwalk has sections with no rails, and darkened areas that don't become light until your kart comes to a certain spot. It is a wooden boardwalk with a crumbling old castle. Occasionally, a giant Cheep Cheep will jump overhead (the Giant Cheep-Cheep cannot harm you). Also, as with most of the haunted tracks, Boos will frequently appear, cackle and then disappear. There are also bats that fly around in two parts in the castle, where they try to rush out at the player. The music creates a very creepy and suspenseful atmosphere."),
                new Track("Bowser's Castle", "HARD",
                        "The course features many 90 degree turns and a variety of hazards such as Thwomps, fire-breathing statues, and lava bridges. In a giant hallway of the castle, a pair of Thwomps moves along in front of the driver, following their motions, and will either block or squish them. In one area of the castle, a green Thwomp, nicknamed Marty by fans, can be seen behind jail bars laughing at passing racers."),
                new Track("Kalimari Desert", "EASY",
                        "Kalimari Desert takes place on an orange desert with a mesa in the middle of the track. It's a medium length track with a few hazards, especially two trains that drive on the rails clockwise, bowling over any racers are ram into them when they approach a crossing. There is also cacti spread throughout the course that cause spin-outs. As the track lacks barriers, it is possible to drive too far outside the main road, counting as out-of-bounds, requiring Lakitu to pick the player up. Racers can also traverse the rails."),
                new Track("Moo Moo Farm", "EASY",
                        "The race course itself is very simple; it is essentially a dirt path through some fields. It is a disjointed oval. The track is very wide and bumpy; players can fly over some of the bumps. There are only groups of Monty Moles as hazards, making this course quite straightforward. They pop up and knock over any karts that drive over them. This track shares the same music with Yoshi Valley."),
                new Track("Rainbow Road", "HARD",
                        "At 2,000 meters (2 kilometers), Rainbow Road is the longest course in the game and longest 3 lap course in the series, taking a minute and a half on average to complete one lap and approximately five minutes for the whole course. Similar to the original Rainbow Road in Super Mario Kart, the track is set on a rainbow-colord road in the night sky, however the road itself features a semi-transparent stained glass-like appearance as opposed to the original's blocky design. This Rainbow Road uniquely features barricades throughout the entire course, a trait not seen in any other mainline Mario Kart game. Chain Chomps are the main obstacle in the course which travel in the opposite direction. Neon lights of the eight playable characters, as well as the Mushroom and Boo items, can be seen throughout the course."),
                new Track("Toad's Turnpike", "NORMAL",
                        "The track consists of a closed off highway in a figure-8 shape. A few parking spaces along the edge have a line of Item Boxes, so those supply really well. At one point in the middle, the track drops slowly so that the bridge can pass over it. It is crowded with traffic, and even just slightly tapping a vehicle will send you into the air. Also, they can be very unmerciful, as you can keep hitting them over and over again, like the rainbow Super Thwomps on Rainbow Road (SNES)."),
                new Track("Wario Staduim", "HARD",
                        "The starting line is over to the far right of the course, which in itself is a dense pile of roads scrunched together into a rounded square-shape. Surrounding the stadium completely is are rows of spectators, seats filled to the brim. The outer edge has a repetitious turquoise design of Wario all over it, matching his prideful nature. Towering multi-bulb stadium lights brightly shower the entire arena, and for those seated too far away from the action, a monstrous TV screen displays a close-up of the race near the front end of the crowd... So, at the beginning of the dark brown track, players immediately are met with four large humps, making them hop up into the air and possibly lose control is they aren't ready. A left curve gets players up to an even larger hill of sand, which drops them off with a \"POOMP\"! at the first row of Item Boxes. Two more left turns, kinda making a large U-turn, follow, and fork in the road seems to come into view; however, going left leads to a wall (previously not visible), and if the driver played it smart, they'll have followed the red pointing arrow to the right."),
                new Track("Yoshi Valley", "NORMAL",
                        "The course starts out on a dirt road with grass on the sides, like DK's Jungle Parkway. After a bit, it transitions into a winding maze of roads on cliffs. These paths are very hard to navigate, even if players are with another person. Adding to the difficulty is multiple Porcupines sprawled over sections of the road, and your only option really is to drive through them and hope that you don't get hit.")
        };

        for (int i = 0; i < tracks.length; i++) {
            trackRepository.save(tracks[i]);
        }
    }
}