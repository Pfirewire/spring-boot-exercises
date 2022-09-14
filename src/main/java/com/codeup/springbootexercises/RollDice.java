package com.codeup.springbootexercises;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String showRollDiceLinks() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDiceGuess(@PathVariable int guess, Model model) {
        int diceRoll = ThreadLocalRandom.current().nextInt(1, 7);
        boolean guessedCorrectly = guess == diceRoll;
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("guess", guess);
        model.addAttribute("guessedCorrectly", guessedCorrectly);
        return "dice-guess";
    }
}
