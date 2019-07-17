package disc.StevenBot;

import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter{
	
	String[] messages = {
			"[member] has arrived. We've been expecting you!",
			"A wild [member] has appeared.",
			"[member] just joined the server. Everyone, look busy!",
			"[member] has spawned in the server.",
			"Welcome, [member]. Stay awhile and listen."
	};
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event){
		Random rand = new Random();
		int num = rand.nextInt(messages.length);
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0x66d8ff);
		join.setDescription(messages[num].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
		
		//Roles
		event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Member",true)).complete();
	}
}
