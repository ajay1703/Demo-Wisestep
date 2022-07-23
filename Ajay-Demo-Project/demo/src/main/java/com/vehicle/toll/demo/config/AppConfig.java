


	import org.springframework.beans.factory.annotation.Value;


	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

	@Configuration
	@ComponentScan("com.vehicle.toll")
	public class AppConfig {

		@Value("oracle.jdbc.driver.OracleDriver")
		private String driverClassName;

		@Value("jdbc:oracle:thin:@localhost:1521:xe")
	private String url;
		
		@Value("system")
		private String username;

		@Value("system")
		private String password;


		 @SuppressWarnings("deprecation")
		@Bean
		    public WebMvcConfigurer corsConfigurer() {
		        return new WebMvcConfigurerAdapter() {
		            @Override
		            public void addCorsMappings(CorsRegistry registry) {
		                registry.addMapping("/**");
		            }
		        };
		    }
	
		@Bean
		public DriverManagerDataSource createDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);

			return dataSource;
		}

		@Bean
		public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate() {
			return new NamedParameterJdbcTemplate(createDataSource());
		}
		
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		return new JdbcTemplate(createDataSource());
	}


}