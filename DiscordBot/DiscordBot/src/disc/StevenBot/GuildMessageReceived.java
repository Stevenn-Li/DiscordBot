package disc.StevenBot;


import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.util.Timer;

public class GuildMessageReceived extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("~mute")){
			if (args.length == 2){
				Member member = event.getGuild().getMemberById(args[1].replace("<@","").replace(">",""));
				Role role = event.getGuild().getRoleById("600767612460466196");
				
				if (!member.getRoles().contains(role)){
					//Mute user
					event.getChannel().sendMessage("Muted " + args[1] + ".").queue();
					event.getGuild().getController().addRolesToMember(member, role).complete();
				}
				else{
					//Unmute
					event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
					event.getGuild().getController().removeSingleRoleFromMember(member, role).complete();
				}
			}
			else if (args.length == 3){
				Member member = event.getGuild().getMemberById(args[1].replace("<@","").replace(">",""));
				Role role = event.getGuild().getRoleById("600767612460466196");
				
				event.getChannel().sendMessage("Muted " + args[1] + " for " + args[2] + " seconds").queue();
				event.getGuild().getController().addRolesToMember(member, role).complete();
				
				Timer timer = new Timer();
				timer.schedule(
						new java.util.TimerTask(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								event.getChannel().sendMessage(args[1] + " is now unmuted after being muted for " + args[2] + " seconds.").queue();
								event.getGuild().getController().removeRolesFromMember(member, role).complete();
							}
						}, Integer.parseInt(args[2])*1000);
			}
			else{
				event.getChannel().sendMessage("Incorrect Syntax. Use ~mute [member] [time amount]").queue();
			}
			
			
		}
	}
}
