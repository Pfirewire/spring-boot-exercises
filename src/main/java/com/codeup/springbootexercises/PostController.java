package com.codeup.springbootexercises;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed fermentum mauris ut velit bibendum ultrices. Suspendisse ut volutpat quam. Ut aliquet turpis vel ultrices tincidunt. Maecenas non lectus elementum, viverra diam at, varius risus. Etiam vitae maximus dolor, vel varius ligula. Suspendisse mollis dolor magna, vitae molestie orci condimentum ut. Morbi ultricies neque in ipsum pellentesque, in malesuada magna vulputate. Mauris hendrerit quis purus id fermentum.\n" +
                        "\n" +
                        "Vivamus maximus vehicula dui id facilisis. Proin et sagittis diam, ut sollicitudin mi. Donec vitae nunc a turpis consectetur rutrum a id metus. Fusce ultricies dui eu magna dictum tincidunt. Mauris a tempus arcu, sed tempor felis. Cras pulvinar laoreet magna nec volutpat. In aliquam ac neque sit amet ullamcorper. Sed pulvinar lacinia dolor, eu aliquam mauris porttitor in. Maecenas neque turpis, feugiat sit amet venenatis in, accumsan eget magna. In hac habitasse platea dictumst. Donec ante ligula, euismod vitae pharetra et, venenatis a eros.\n" +
                        "\n" +
                        "Praesent vestibulum tempus ante. Pellentesque eget maximus massa. Donec id magna nunc. Quisque quis enim orci. Nullam accumsan leo eu ligula fermentum cursus. Duis ac fermentum lorem, quis facilisis augue. Vivamus egestas imperdiet mi vel tristique. Morbi accumsan, purus ut volutpat scelerisque, velit ex dictum sapien, at mattis enim lectus nec orci. Morbi tempor vitae ex vitae suscipit. Curabitur dapibus, elit sed elementum fermentum, enim lorem blandit justo, eget commodo nulla dolor a lacus. Integer sed diam viverra, mollis nisi et, luctus metus. Duis vel pellentesque lectus.\n" +
                        "\n" +
                        "Duis ac pharetra ex. Nullam luctus porttitor finibus. Vestibulum eget nunc in ante aliquet tincidunt. Maecenas eget odio vel tellus tincidunt porta. Praesent lectus enim, tempor non porttitor eu, aliquet sit amet odio. Aliquam varius mauris metus. Quisque eleifend molestie metus sed tristique. Etiam ac dolor rhoncus, ornare turpis quis, facilisis elit. Vivamus non magna eu velit semper ultricies. Morbi eu blandit sapien. Sed tincidunt iaculis ante eget viverra. Morbi eu enim sed lorem aliquet hendrerit eget a lorem. Sed ac urna ac nunc rutrum facilisis. Aenean in tempus enim. Curabitur laoreet, purus non maximus scelerisque, urna odio accumsan lorem, eu lobortis felis elit ac orci. Mauris eget est magna.\n" +
                        "\n" +
                        "Integer dignissim nulla lobortis, viverra diam in, hendrerit sapien. Etiam lacinia a sapien at tempor. Morbi ullamcorper tincidunt ante, a tincidunt augue consequat a. Aliquam nisl tortor, rutrum ac ante eu, sodales ultricies orci. Nunc dictum felis sed elit facilisis convallis. Vivamus id laoreet lacus, fringilla feugiat ligula. Donec lectus dui, venenatis vel sollicitudin at, interdum ac diam. Etiam tincidunt nisi ac mi auctor, non maximus lectus consectetur. Etiam pulvinar, nisl tristique sodales malesuada, ligula velit malesuada ligula, sed feugiat purus turpis sed ante. Nullam lacinia nunc rutrum ultricies tempor. Cras ut nibh nunc. In urna arcu, tempus ullamcorper pellentesque sit amet, condimentum vitae libero. In pretium, tellus nec consectetur ultricies, sapien odio suscipit metus, id rutrum purus urna aliquet justo. Aenean lacinia tempor dolor, at aliquet nisi. "));
        posts.add(new Post("Second Title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed fermentum mauris ut velit bibendum ultrices. Suspendisse ut volutpat quam. Ut aliquet turpis vel ultrices tincidunt. Maecenas non lectus elementum, viverra diam at, varius risus. Etiam vitae maximus dolor, vel varius ligula. Suspendisse mollis dolor magna, vitae molestie orci condimentum ut. Morbi ultricies neque in ipsum pellentesque, in malesuada magna vulputate. Mauris hendrerit quis purus id fermentum.\n" +
                        "\n" +
                        "Vivamus maximus vehicula dui id facilisis. Proin et sagittis diam, ut sollicitudin mi. Donec vitae nunc a turpis consectetur rutrum a id metus. Fusce ultricies dui eu magna dictum tincidunt. Mauris a tempus arcu, sed tempor felis. Cras pulvinar laoreet magna nec volutpat. In aliquam ac neque sit amet ullamcorper. Sed pulvinar lacinia dolor, eu aliquam mauris porttitor in. Maecenas neque turpis, feugiat sit amet venenatis in, accumsan eget magna. In hac habitasse platea dictumst. Donec ante ligula, euismod vitae pharetra et, venenatis a eros.\n" +
                        "\n" +
                        "Praesent vestibulum tempus ante. Pellentesque eget maximus massa. Donec id magna nunc. Quisque quis enim orci. Nullam accumsan leo eu ligula fermentum cursus. Duis ac fermentum lorem, quis facilisis augue. Vivamus egestas imperdiet mi vel tristique. Morbi accumsan, purus ut volutpat scelerisque, velit ex dictum sapien, at mattis enim lectus nec orci. Morbi tempor vitae ex vitae suscipit. Curabitur dapibus, elit sed elementum fermentum, enim lorem blandit justo, eget commodo nulla dolor a lacus. Integer sed diam viverra, mollis nisi et, luctus metus. Duis vel pellentesque lectus.\n" +
                        "\n" +
                        "Duis ac pharetra ex. Nullam luctus porttitor finibus. Vestibulum eget nunc in ante aliquet tincidunt. Maecenas eget odio vel tellus tincidunt porta. Praesent lectus enim, tempor non porttitor eu, aliquet sit amet odio. Aliquam varius mauris metus. Quisque eleifend molestie metus sed tristique. Etiam ac dolor rhoncus, ornare turpis quis, facilisis elit. Vivamus non magna eu velit semper ultricies. Morbi eu blandit sapien. Sed tincidunt iaculis ante eget viverra. Morbi eu enim sed lorem aliquet hendrerit eget a lorem. Sed ac urna ac nunc rutrum facilisis. Aenean in tempus enim. Curabitur laoreet, purus non maximus scelerisque, urna odio accumsan lorem, eu lobortis felis elit ac orci. Mauris eget est magna.\n" +
                        "\n" +
                        "Integer dignissim nulla lobortis, viverra diam in, hendrerit sapien. Etiam lacinia a sapien at tempor. Morbi ullamcorper tincidunt ante, a tincidunt augue consequat a. Aliquam nisl tortor, rutrum ac ante eu, sodales ultricies orci. Nunc dictum felis sed elit facilisis convallis. Vivamus id laoreet lacus, fringilla feugiat ligula. Donec lectus dui, venenatis vel sollicitudin at, interdum ac diam. Etiam tincidunt nisi ac mi auctor, non maximus lectus consectetur. Etiam pulvinar, nisl tristique sodales malesuada, ligula velit malesuada ligula, sed feugiat purus turpis sed ante. Nullam lacinia nunc rutrum ultricies tempor. Cras ut nibh nunc. In urna arcu, tempus ullamcorper pellentesque sit amet, condimentum vitae libero. In pretium, tellus nec consectetur ultricies, sapien odio suscipit metus, id rutrum purus urna aliquet justo. Aenean lacinia tempor dolor, at aliquet nisi. "));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        Post post = new Post("Title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed fermentum mauris ut velit bibendum ultrices. Suspendisse ut volutpat quam. Ut aliquet turpis vel ultrices tincidunt. Maecenas non lectus elementum, viverra diam at, varius risus. Etiam vitae maximus dolor, vel varius ligula. Suspendisse mollis dolor magna, vitae molestie orci condimentum ut. Morbi ultricies neque in ipsum pellentesque, in malesuada magna vulputate. Mauris hendrerit quis purus id fermentum.\n" +
                "\n" +
                "Vivamus maximus vehicula dui id facilisis. Proin et sagittis diam, ut sollicitudin mi. Donec vitae nunc a turpis consectetur rutrum a id metus. Fusce ultricies dui eu magna dictum tincidunt. Mauris a tempus arcu, sed tempor felis. Cras pulvinar laoreet magna nec volutpat. In aliquam ac neque sit amet ullamcorper. Sed pulvinar lacinia dolor, eu aliquam mauris porttitor in. Maecenas neque turpis, feugiat sit amet venenatis in, accumsan eget magna. In hac habitasse platea dictumst. Donec ante ligula, euismod vitae pharetra et, venenatis a eros.\n" +
                "\n" +
                "Praesent vestibulum tempus ante. Pellentesque eget maximus massa. Donec id magna nunc. Quisque quis enim orci. Nullam accumsan leo eu ligula fermentum cursus. Duis ac fermentum lorem, quis facilisis augue. Vivamus egestas imperdiet mi vel tristique. Morbi accumsan, purus ut volutpat scelerisque, velit ex dictum sapien, at mattis enim lectus nec orci. Morbi tempor vitae ex vitae suscipit. Curabitur dapibus, elit sed elementum fermentum, enim lorem blandit justo, eget commodo nulla dolor a lacus. Integer sed diam viverra, mollis nisi et, luctus metus. Duis vel pellentesque lectus.\n" +
                "\n" +
                "Duis ac pharetra ex. Nullam luctus porttitor finibus. Vestibulum eget nunc in ante aliquet tincidunt. Maecenas eget odio vel tellus tincidunt porta. Praesent lectus enim, tempor non porttitor eu, aliquet sit amet odio. Aliquam varius mauris metus. Quisque eleifend molestie metus sed tristique. Etiam ac dolor rhoncus, ornare turpis quis, facilisis elit. Vivamus non magna eu velit semper ultricies. Morbi eu blandit sapien. Sed tincidunt iaculis ante eget viverra. Morbi eu enim sed lorem aliquet hendrerit eget a lorem. Sed ac urna ac nunc rutrum facilisis. Aenean in tempus enim. Curabitur laoreet, purus non maximus scelerisque, urna odio accumsan lorem, eu lobortis felis elit ac orci. Mauris eget est magna.\n" +
                "\n" +
                "Integer dignissim nulla lobortis, viverra diam in, hendrerit sapien. Etiam lacinia a sapien at tempor. Morbi ullamcorper tincidunt ante, a tincidunt augue consequat a. Aliquam nisl tortor, rutrum ac ante eu, sodales ultricies orci. Nunc dictum felis sed elit facilisis convallis. Vivamus id laoreet lacus, fringilla feugiat ligula. Donec lectus dui, venenatis vel sollicitudin at, interdum ac diam. Etiam tincidunt nisi ac mi auctor, non maximus lectus consectetur. Etiam pulvinar, nisl tristique sodales malesuada, ligula velit malesuada ligula, sed feugiat purus turpis sed ante. Nullam lacinia nunc rutrum ultricies tempor. Cras ut nibh nunc. In urna arcu, tempus ullamcorper pellentesque sit amet, condimentum vitae libero. In pretium, tellus nec consectetur ultricies, sapien odio suscipit metus, id rutrum purus urna aliquet justo. Aenean lacinia tempor dolor, at aliquet nisi. ");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostGet() {
        return "view the form for creating post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostPost() {
        return "creates a new post";
    }
}
