package disc.StevenBot;

import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMemberLeave extends ListenerAdapter{
	
	String[] messages = {
			"[member] has left. We'll miss you!",
			"A wild [member] has fled.",
			"[member] just left the server. Everyone, PARTY!",
			"[member] has despawned from the server.",
			"Goodbye, [member]. It was nice knowing you."
	};
	
	public void onGuildMemberLeave(GuildMemberLeaveEvent event){
		Random rand = new Random();
		int num = rand.nextInt(messages.length);
		
		EmbedBuilder exit = new EmbedBuilder();
		exit.setColor(0xf48342);
		exit.setDescription(messages[num].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(exit.build()).queue();
	}
}	
