package disc.StevenBot;

import java.util.Random;
import java.util.Timer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reminder extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("~remind")){
			if (args.length == 3 && !args[2].contains(".") && (Integer.parseInt(args[2]) > 0)){			
				EmbedBuilder reminder = new EmbedBuilder();
				reminder.setTitle("Reminder: " + args[1]);
				reminder.setDescription("Time Duration: " + args[2] + " seconds.");
				reminder.setColor(0xa442f5);
				event.getChannel().sendMessage(reminder.build()).queue();
				Timer timer = new Timer();
				timer.schedule(
						new java.util.TimerTask(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								EmbedBuilder reminded = new EmbedBuilder();
								reminded.setTitle("Reminder for: " + args[1] + " complete.");
								reminded.setColor(0xf542ec);
								event.getChannel().sendMessage(reminded.build()).queue();
							}
						}, Integer.parseInt(args[2])*1000);
			}
			else{
				event.getChannel().sendMessage("Incorrect Syntax. Use ~remind [Description] [time amount]").queue();
			}
		}
	}
}
