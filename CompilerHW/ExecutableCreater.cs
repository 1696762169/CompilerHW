using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompilerHW
{
    /// <summary>
    /// 可执行文件生成器（通过LLVM Module）
    /// </summary>
    internal static class ExecutableCreater
    {
        /// <summary>
        /// 读入bitcode并将可执行文件写入指定路径
        /// </summary>
        public static void CreateExecutable(string bcPath, string outputPath)
        {
            // 检查bitcode是否存在
            string fileName = Path.GetFileNameWithoutExtension(bcPath);
            if (!File.Exists(bcPath))
            {
                Console.WriteLine($"未找到Bitcode文件：{bcPath}");
                return;
            }
            // 检查可执行文件路径
            string? outDir = Path.GetDirectoryName(outputPath);
            if (outDir != null && !Directory.Exists(outDir))
                Directory.CreateDirectory(outDir);

            try
            {
                // 生成目标文件
                Run("clang", $"-c -o {Path.Join(outDir, fileName)}.o {bcPath}");
                // 链接形成可执行文件
                Run("lld", $"-flavor gnu -o {outputPath} {Path.Join(outDir, fileName)}.o");
            }
            catch
            {
                // ignored
            }
        }

        private static void Run(string fileName, string arguments)
        {
            ProcessStartInfo info = GetDefaultInfo(fileName, arguments);
            Process process = new() { StartInfo = info };
            process.Start();
            process.WaitForExit();
            PrintInfo(process);
        }

        private static ProcessStartInfo GetDefaultInfo(string fileName, string arguments)
        {
            return new ProcessStartInfo
            {
                FileName = fileName,
                Arguments = arguments,
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true,
                CreateNoWindow = true,
            };
        }

        private static void PrintInfo(Process process)
        {
            string output = process.StandardOutput.ReadToEnd();
            string error = process.StandardError.ReadToEnd();

            if (!string.IsNullOrEmpty(output))
            {
                Console.WriteLine(output);
            }

            if (!string.IsNullOrEmpty(error))
            {
                Console.ForegroundColor = ConsoleColor.DarkRed;
                Console.WriteLine("Error: " + error);
                Console.ForegroundColor = ConsoleColor.White;
                throw new Exception(error);
            }
        }
    }
}
