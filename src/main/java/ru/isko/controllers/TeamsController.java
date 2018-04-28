package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.forms.TeamsForm;
import ru.isko.models.Country;
import ru.isko.models.FileInfo;
import ru.isko.repositories.countries.CountriesRepository;
import ru.isko.repositories.file_info.FileInfoRepository;
import ru.isko.repositories.players.PlayersRepository;
import ru.isko.services.FileStorageService;

/**
 * created by Iskander Valiev
 * on 12/7/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class TeamsController {

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private PlayersRepository playersRepository;

    @GetMapping("/admin/add/team")
    public String addTeamPage() {
        return "new_team";
    }

    @PostMapping("/admin/add/team")
    public String addTeam(@RequestParam("file") MultipartFile file, TeamsForm teamsForm) {
        String imagePath = fileStorageService.saveFile(file);
        FileInfo fileInfo = fileInfoRepository.findOneByStorageFileName(imagePath);

        countriesRepository.save(Country.builder()
                                .name(teamsForm.getCountryName())
                                .flag(fileInfo)
                                .build());
        return "redirect:/user/teams";
    }

    @GetMapping("/user/team/{team-id}/players")
    public String getPlayersByCountry(@PathVariable("team-id")Long teamID, @ModelAttribute("model")ModelMap model) {
        model.addAttribute("players", playersRepository.findAllByCountry(countriesRepository.findOne(teamID)));
        model.addAttribute("country", countriesRepository.findOne(teamID).getName());
        return "selected_team";
    }
}
